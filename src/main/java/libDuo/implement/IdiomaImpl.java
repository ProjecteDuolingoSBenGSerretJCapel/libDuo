package libDuo.implement;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.IIdiomaDAO;
import libDuo.model.Curs;
import libDuo.model.Idioma;
import libDuo.util.HibernateUtil;

public class IdiomaImpl implements IIdiomaDAO{

	@Override
	public Idioma setIdioma(Idioma idioma, String nomNouIdioma) {
		Idioma nouIdioma = idioma;
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			nouIdioma.setIdioma(nomNouIdioma);
			session.save(nouIdioma);
			t.commit();
			return nouIdioma;
			
		}catch(Exception e) {
			e.printStackTrace();
			return nouIdioma;
		}
	}

	@Override
	public Idioma getIdiomaByName(String nomIdioma) {
		Idioma idioma = null;
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			ArrayList<Idioma> arrayListTotsElsIdiomes = getAllIdiomes();
			for (int i = 0; i < arrayListTotsElsIdiomes.size(); i++) {
				if(arrayListTotsElsIdiomes.get(i).getIdioma().equalsIgnoreCase(nomIdioma)) {
					 idioma = arrayListTotsElsIdiomes.get(i);
				}
			}
			t.commit();
			return idioma;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Idioma> getAllIdiomes() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			ArrayList<Idioma> list = (ArrayList<Idioma>) session.createCriteria(Idioma.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
