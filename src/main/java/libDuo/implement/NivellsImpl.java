package libDuo.implement;

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

}
