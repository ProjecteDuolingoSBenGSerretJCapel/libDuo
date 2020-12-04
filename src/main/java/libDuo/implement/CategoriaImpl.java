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
	public Categoria setNovaCategoria(String nomNovaCategoria, Curs curs) {
		Categoria categoria = new Categoria();
		
		ArrayList<Categoria> arrayListCategoria = new ArrayList<Categoria>();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			
			categoria.setTipusCategoria(nomNovaCategoria);
			arrayListCategoria.add(categoria);
			curs.setCategoria(arrayListCategoria);
			
			session.save(categoria);		
			t.commit();
			return categoria;
		}catch(Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}

	@Override
	public List<Categoria> getAllCategoriesByCurs(Curs curs) {
		ICategoriaDAO icmanager = new CategoriaImpl();
		ArrayList<Categoria> arrayTotesCategories = icmanager.getAllCategorias();
		
		ArrayList<Categoria> arrayCategoriaCurs = new ArrayList<Categoria>();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < arrayTotesCategories.size(); i++) {
				if(arrayTotesCategories.get(i).getCurs() == curs) {
					arrayCategoriaCurs.add(arrayTotesCategories.get(i));
				}
			}
			
			t.commit();
			return arrayCategoriaCurs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Categoria> getAllCategoriesByIdiomaOrigen(Curs curs) {
		ICategoriaDAO icmanager = new CategoriaImpl();
		ArrayList<Categoria> arrayTotesCategories = icmanager.getAllCategorias();
		
		ArrayList<Categoria> arrayCategoriaCurs = new ArrayList<Categoria>();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < arrayTotesCategories.size(); i++) {
				if(arrayTotesCategories.get(i).getCurs().getIdiomaOrigen() == curs.getIdiomaDesti()) {
					arrayCategoriaCurs.add(arrayTotesCategories.get(i));
				}
			}
			
			t.commit();
			return arrayCategoriaCurs;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria getCategoriaByIdCurs(long idCurs) {
		ICategoriaDAO icmanager = new CategoriaImpl();
		ArrayList<Categoria> arrayListCategoria = icmanager.getAllCategorias();
		
		Categoria categoria = new Categoria();
		Transaction t = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			t = session.beginTransaction();
			for (int i = 0; i < arrayListCategoria.size(); i++) {
				if(arrayListCategoria.get(i).getCurs().getIdCurs() == idCurs) {
					categoria = arrayListCategoria.get(i);
				}
			}
			t.commit();
			return categoria;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
