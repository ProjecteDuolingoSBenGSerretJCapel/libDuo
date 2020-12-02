package libDuo.Dao;

import java.util.ArrayList;

import libDuo.model.Curs;
import libDuo.model.Idioma;



public interface ICursDAO {

	//comprobar si el curs que esta fent esta comencat, o no
	public boolean cursComencat();
	
	public ArrayList<Curs> getAllCursos();
	
	public Curs getCursById(long idCurs);
	
	public Curs getCursByNom(String nomCurs);
	
	public boolean setOrigenDesti(Idioma idiomaDesti, Curs curs);
	
	public boolean setOrigenOrigen(Idioma idiomaOrigen, Curs curs);
	
}
