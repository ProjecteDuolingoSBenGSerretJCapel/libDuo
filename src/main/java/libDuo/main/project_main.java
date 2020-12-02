package libDuo.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.ITextIdiomes;
import libDuo.implement.TextIdiomasImpl;
import libDuo.model.*;
import libDuo.util.HibernateUtil;



public class project_main {
	
	public static void main(String[] args) {
		ITextIdiomes icmanagerTextIdiomes = new TextIdiomasImpl();
		ArrayList<String> idiomes = icmanagerTextIdiomes.leerFicheroDeIdiomes();
		icmanagerTextIdiomes.setAllIdiomes(idiomes);
		
		ArrayList<Curs> aCurs = new ArrayList<Curs>();
		Curs c1 = new Curs();
		Curs c2 = new Curs();
		Curs c3 = new Curs();
		
		Idioma i1 = new Idioma();
		i1.setIdioma("Castella");
		Idioma i2 = new Idioma();
		i2.setIdioma("Catala");
		Idioma i3 = new Idioma();
		i3.setIdioma("Angles");
		Idioma i4 = new Idioma();
		i4.setIdioma("Frances");
		
		aCurs.add(c1);
		aCurs.add(c2);
		aCurs.add(c3);
		
		i1.setCursos(aCurs);
		i2.setCursos(aCurs);
		i3.setCursos(aCurs);
		i4.setCursos(aCurs);
		
		c1.setIdiomaOrigen(i1);
		c1.setIdiomaDesti(i3);
		
		c2.setIdiomaOrigen(i2);
		c2.setIdiomaDesti(i3);
		
		c3.setIdiomaOrigen(i3);
		c3.setIdiomaDesti(i1);
		
		Transaction t = null;
				
				try(Session session =
						HibernateUtil.getSessionFactory().openSession()){
					
					t = session.beginTransaction();
					session.save(c1);
					session.save(c2);
					session.save(c3);
					
					session.save(i1);
					session.save(i2);
					session.save(i3);
					session.save(i4);
					t.commit();
					
				}catch(Exception e){
				
					
					
				}
		
	}

}
