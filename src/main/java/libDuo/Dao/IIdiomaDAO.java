package libDuo.Dao;

import java.util.ArrayList;

import libDuo.model.Idioma;

public interface IIdiomaDAO {
	
	//afegir un idioma a temari del usuari
	public Idioma setIdioma(Idioma idioma, String nomNouIdioma);
	
	public Idioma getIdiomaByName(String nomIdioma);
	
	public ArrayList<Idioma> getAllIdiomes();
	
	
}

