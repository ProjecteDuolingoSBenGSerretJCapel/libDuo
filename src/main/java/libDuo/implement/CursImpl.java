package libDuo.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;


import libDuo.Dao.*;
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
	public boolean setIdiomaDesti(Idioma idiomaDesti, Curs curs) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			curs.setIdiomaDesti(idiomaDesti);;
			session.save(curs);
			t.commit();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setIdiomaOrigen(Idioma idiomaOrigen, Curs curs) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			curs.setIdiomaDesti(idiomaOrigen);;
			session.save(curs);
			t.commit();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
