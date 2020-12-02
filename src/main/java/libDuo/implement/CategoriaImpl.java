package libDuo.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import libDuo.Dao.ICategoriaDAO;
import libDuo.model.*;
import libDuo.util.HibernateUtil;


public class CategoriaImpl implements ICategoriaDAO{

	@Override
	public List<Categoria> getAllCategories() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			List<Categoria> list = session.createCriteria(Categoria.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria getCategoriaById(long idCategoria) {
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
