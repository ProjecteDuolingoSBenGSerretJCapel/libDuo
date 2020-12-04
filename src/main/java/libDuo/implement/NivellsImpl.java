package libDuo.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.INivellsDAO;
import libDuo.model.*;
import libDuo.util.HibernateUtil;


public class NivellsImpl implements INivellsDAO{

	@Override
	public List<Nivells> getAllNivells() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			List<Nivells> list = session.createCriteria(Nivells.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Nivells getnivellById(long idNivell) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			Nivells nivells = session.find(Nivells.class, idNivell);
			t.commit();
			
			return nivells;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Nivells setNouNivell(String nomNouNivell, int numNivell, Categoria categoria) {
		Nivells nivell = new Nivells();
		
		ArrayList<Nivells> arrayListNivells = new ArrayList<Nivells>();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			nivell.setNomNivell(nomNouNivell);
			nivell.setNivell(numNivell);
			arrayListNivells.add(nivell);
			
			categoria.setNivells(arrayListNivells);
			session.save(nivell);
			session.update(categoria);
			t.commit();
			
			return nivell;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria getCategoriaByIdCategoria(long idCategoria) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			Categoria categoria = session.find(Categoria.class, idCategoria);
			t.commit();
			
			return categoria;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
