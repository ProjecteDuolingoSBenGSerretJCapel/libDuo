package libDuo.implement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.IExercicisDAO;
import libDuo.model.*;
import libDuo.util.HibernateUtil;


public class ExercicisImpl implements IExercicisDAO{

	@Override
	public boolean exerciciComencat() {
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
	public List<Exercicis> getAllExercicis() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			List<Exercicis> list = session.createCriteria(Exercicis.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Exercicis getExerciciById(long idExercici) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			Exercicis exercicis = session.find(Exercicis.class, idExercici);
			t.commit();
			
			return exercicis;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Exercicis setNouExercici( Nivells nivell , String fitxerExercici) {
		
		Exercicis exercici = new Exercicis();
		
		ArrayList <Exercicis> arrayListExercicis= new ArrayList<Exercicis>();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			exercici.setNivell(nivell);
			exercici.setFitxerDades(fitxerExercici);
			arrayListExercicis.add(exercici);
			nivell.setExercicis(arrayListExercicis);
			session.save(exercici);
			session.update(nivell);
			t.commit();
			return exercici;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
