package libDuo.Dao;

import java.util.List;

import libDuo.model.Exercicis;



public interface IExercicisDAO {

	//comprobar si el exerici esta comencat o encara no
	public boolean exerciciComencat();
	
	public List<Exercicis> getAllExercicis();
	
	public Exercicis getExerciciById(long idExercici);
}
