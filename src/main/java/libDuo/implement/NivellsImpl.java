package libDuo.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.ICategoriaDAO;
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
			nivell.setCategoria(categoria);
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
	public List<Nivells> getAllNivellsByCategoria(Categoria categoria) {
		INivellsDAO icmanager = new NivellsImpl();
		ArrayList<Nivells> arrayTotsNivells = (ArrayList<Nivells>) icmanager.getAllNivells();
		
		ArrayList<Nivells> arrayNivellCategoria = new ArrayList<Nivells>();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < arrayTotsNivells.size(); i++) {
				if(arrayTotsNivells.get(i).getCategoria().getIdCategoria() == categoria.getIdCategoria()) {
					arrayNivellCategoria.add(arrayTotsNivells.get(i));
				}
			}
			
			t.commit();
			return arrayNivellCategoria;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Nivells getNivellByName(String nomNivell) {
		Nivells nivell = null;
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			ArrayList<Nivells> arrayListTotsElsNivells = (ArrayList<Nivells>) getAllNivells();
			for (int i = 0; i < arrayListTotsElsNivells.size(); i++) {
				if(arrayListTotsElsNivells.get(i).getNomNivell().equalsIgnoreCase(nomNivell)) {
					 nivell = arrayListTotsElsNivells.get(i);
				}
			}
			t.commit();
			return nivell;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
