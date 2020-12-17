package libDuo.Dao;

import java.io.File;
import java.util.List;

import libDuo.model.Exercicis;
import libDuo.model.Nivells;



public interface IExercicisDAO {

	//comprobar si el exerici esta comencat o encara no
	public boolean exerciciComencat();
	
	public List<Exercicis> getAllExercicis();
	
	public Exercicis getExerciciById(long idExercici);

	Exercicis setNouExercici(Nivells nivell, String jsonString);

	List<Exercicis> getAllExercicisByNivell(Nivells nivell);
	
	public String getDadesEx(Exercicis exercici);
}
