package libDuo.Dao;

import java.util.ArrayList;

import libDuo.model.Idioma;

public interface IIdiomaDAO {
	
	//afegir un idioma a temari del usuari
	public boolean afegirIdioma();
	
	public Idioma getIdiomaByName(String nomIdioma);
	
	public ArrayList<Idioma> getAllIdiomes();
	
	
}

