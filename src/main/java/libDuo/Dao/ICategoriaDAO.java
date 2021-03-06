package libDuo.Dao;

import java.util.ArrayList;
import java.util.List;

import libDuo.model.Categoria;
import libDuo.model.Curs;
import libDuo.model.Idioma;



public interface ICategoriaDAO {
	
	public List<Categoria> getAllCategories();
	
	public List<Categoria> getAllCategoriesByCurs(Curs curs);
	
	public Categoria getCategoriaById(long idCategoria);
	
	public ArrayList<Categoria> getAllCategorias();
	
	public Categoria getCategoriaByName(String nomCategoria);
	
	public Categoria setNovaCategoria(String nomNovaCategoria, Curs curs);
	
	public ArrayList<Categoria> getAllCategoriesByIdiomaOrigen(Curs curs);
	
	public Categoria getCategoriaByIdCurs(long idCurs);
	
	
}
