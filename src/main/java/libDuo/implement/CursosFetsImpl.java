package libDuo.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.ICursosFetsDAO;
import libDuo.model.*;
import libDuo.util.HibernateUtil;


public class CursosFetsImpl implements ICursosFetsDAO{

	@Override
	public boolean cursAcabat() {
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
	public int quantsCursosAcabats() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			t.commit();
			return 1;
			
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<CursosFets> getAllCursosFets() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			List<CursosFets> list = session.createCriteria(CursosFets.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public CursosFets getCursFetById(long idCursFet) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			CursosFets cursosFets = session.find(CursosFets.class, idCursFet);
			t.commit();
			
			return cursosFets;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
