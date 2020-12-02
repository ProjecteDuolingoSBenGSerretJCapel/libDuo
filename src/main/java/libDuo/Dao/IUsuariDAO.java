package libDuo.Dao;

import java.sql.Date;

public interface IUsuariDAO {
	
	//introduir el nom del usuari
	public String introduirNomUsuari(String nom);
	
	//introduir el cognom del usuari
	public String introduirCognomUsuari(String cognom);
	
	//introduir la data de naixament del usuari
	public Date introduirDataNaixamentUsuari(Date dataNaixament);
	
	//introduir el correu del usurai
	public String introduirCorreuUsuari(String correu);
	
	//introduir la contrasena del usuari
	public String introduirContrasenaUsuari(String contrasena);
	
	//introduir el nickname del usuari
	public String introduirNickNameUsuari(String usuari);
	
	//saber que totes les dades que necesita per fer un login estigin totes be
	public boolean afegirUsuari(String nom, String cognom, Date dataNaixament, String correu, String  contrasena, String usuari);

}
