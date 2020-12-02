package libDuo.Dao;

import java.util.List;

import libDuo.model.Nivells;



public interface INivellsDAO {

	public List<Nivells> getAllNivells();
	
	public Nivells getnivellById(long idNivell);
}
