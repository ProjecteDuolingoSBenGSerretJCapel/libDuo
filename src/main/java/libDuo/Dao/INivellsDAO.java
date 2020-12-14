package libDuo.Dao;

import java.util.List;

import libDuo.model.Categoria;
import libDuo.model.Nivells;



public interface INivellsDAO {

	public List<Nivells> getAllNivells();
	
	public Nivells getnivellById(long idNivell);
	
	public Nivells setNouNivell(String nomNouNivell, int numNivell, Categoria categoria);
	
	public Categoria getCategoriaByIdCategoria(long idCategoria);
	
	public List<Nivells>  getAllNivellsByCategoria(Categoria categoria );
}
