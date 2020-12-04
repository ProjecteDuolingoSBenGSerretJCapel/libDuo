package libDuo.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;


import libDuo.Dao.*;
import libDuo.model.Categoria;
import libDuo.model.Curs;
import libDuo.model.Idioma;
import libDuo.util.HibernateUtil;



public class CursImpl implements ICursDAO{

	@Override
	public boolean cursComencat() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			t.commit();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public ArrayList<Curs> getAllCursos() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			ArrayList<Curs> list = (ArrayList<Curs>) session.createCriteria(Curs.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Curs getCursById(long idCurs) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			Curs curs = session.find(Curs.class, idCurs);
			t.commit();
			return curs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Curs getCursByNom(String nomCurs) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			Curs curs = session.find(Curs.class, nomCurs);
			t.commit();
			return curs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean setNewCurs(Idioma idiomaOrigen, Idioma idiomaDesti, Curs curs) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			curs.setIdiomaOrigen(idiomaOrigen);
			curs.setIdiomaDesti(idiomaDesti);
			session.save(curs);
			t.commit();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Curs getCursByIds(long idIdiomaDesti, long idIdiomaOrigen) {
		ICursDAO icmanager = new CursImpl();
		ArrayList<Curs> arrayListCurs = icmanager.getAllCursos();
		
		Curs curs = new Curs();
		
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < arrayListCurs.size(); i++) {
				if(arrayListCurs.get(i).getIdiomaOrigen().getIdIdioma() == idIdiomaDesti && 
						arrayListCurs.get(i).getIdiomaDesti().getIdIdioma() == idIdiomaOrigen) {
					curs = arrayListCurs.get(i);
				}
			}
			t.commit();
			return curs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria setCategoriaCurs(long idCurs, Categoria categoria) {
		Curs curs = getCursById(idCurs);
		
		ICategoriaDAO icmanager = new CategoriaImpl();
		ArrayList<Categoria> arrayList = (ArrayList<Categoria>) icmanager.getAllCategoriesByCurs(curs);
		
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			arrayList.add(categoria);
			curs.setCategoria(arrayList);
			session.save(curs);
			t.commit();
			
			return categoria;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


	
}
