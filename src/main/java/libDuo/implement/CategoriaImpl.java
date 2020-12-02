package libDuo.implement;

import java.util.ArrayList;
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

	@Override
	public ArrayList<Categoria> getAllCategorias() {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			ArrayList<Categoria> list = (ArrayList<Categoria>) session.createCriteria(Categoria.class).list();
			t.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria getIdiomaByName(String nomCategoria) {
		Categoria categoria = null;
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			ArrayList<Categoria> arrayListTotsElsIdiomes = getAllCategorias();
			for (int i = 0; i < arrayListTotsElsIdiomes.size(); i++) {
				if(arrayListTotsElsIdiomes.get(i).getTipusCategoria().equalsIgnoreCase(nomCategoria)) {
					 categoria = arrayListTotsElsIdiomes.get(i);
				}
			}
			t.commit();
			return categoria;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean comprobarNovaCategoria(String nomNovaCategoria, ArrayList<Categoria> arrayList) {
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < arrayList.size(); i++) {
				//recorra les categorias de la combinacio per veure si aquella categoria ja esta creada
			}
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void setNovaCategoria(String nomNovaCategoria) {
		Categoria categoria = new Categoria();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			categoria.setTipusCategoria(nomNovaCategoria);
			session.save(categoria);
			t.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
