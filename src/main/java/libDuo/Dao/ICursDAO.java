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
	
	public boolean setNewCurs(Idioma idiomaOrigen, Idioma idiomaDesti,Curs curs);
	
	public Curs getCursByIds(long idIdiomaDesti, long idIdiomaOrigen);
	

	
}
