package libDuo.Dao;

import java.util.List;

import libDuo.model.CursosFets;



public interface ICursosFetsDAO {
	
	//comprobar si el curs que esta fent esta acabat
	public boolean cursAcabat();
	
	//contar quants cursos has acabat
	public int quantsCursosAcabats();
	
	public List<CursosFets> getAllCursosFets();
	
	public CursosFets getCursFetById(long idCursFet);

}
