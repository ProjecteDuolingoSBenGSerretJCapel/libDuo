package libDuo.Dao;

public interface IAmicsDAO {
	
	//buscar en la llista de amics per el seu nickname
	public String buscarAmicPerNickName(String usuari);
	
	//afegir amic per nickname
	public boolean enviarSolicitudAmicPerNickName(String usuari);
	
	//eliminar amic per nickname
	public boolean eliminarAmicPerNickName(String usuari);
	
}
