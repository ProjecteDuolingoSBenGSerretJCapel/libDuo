package libDuo.Dao;

import java.util.List;

import libDuo.model.Categoria;



public interface ICategoriaDAO {
	
	public List<Categoria> getAllCategories();
	
	public Categoria getCategoriaById(long idCategoria);


}
