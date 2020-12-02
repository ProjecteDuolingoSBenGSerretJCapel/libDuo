package libDuo.implement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.ITextIdiomes;
import libDuo.model.Idioma;
import libDuo.util.HibernateUtil;

public class TextIdiomasImpl implements ITextIdiomes{

	@Override
	public void setAllIdiomes(ArrayList<String> idiomesText) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < idiomesText.size(); i++) {
				Idioma idioma = new Idioma();
				idioma.setIdioma(idiomesText.get(i));
				session.save(idioma);
			}
			t.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public ArrayList<String> leerFicheroDeIdiomes() {
		String texto="";
		ArrayList<String> idiomesText = new ArrayList<String>();
		try{
			FileReader lector=new FileReader("/home/super/Escriptori/project_duolingo/desktopDuo/recursos/languageList.txt");
	
			BufferedReader contenido=new BufferedReader(lector);
	
			while((texto=contenido.readLine())!=null){
				idiomesText.add(texto);
			}
		}catch(Exception e){
			System.out.println("Error al leer");
			return null;
		}
		
		return idiomesText;
	}
}
