package libDuo.Dao;

import java.util.ArrayList;
import java.util.List;

import libDuo.model.Categoria;
import libDuo.model.Idioma;



public interface ICategoriaDAO {
	
	public List<Categoria> getAllCategories();
	
	public Categoria getCategoriaById(long idCategoria);
	
	public ArrayList<Categoria> getAllCategorias();
	
	public Categoria getIdiomaByName(String nomCategoria);

	public boolean comprobarNovaCategoria(String nomNovaCategoria, ArrayList<Categoria> arrayList);
	
	public void setNovaCategoria(String nomNovaCategoria);

}
