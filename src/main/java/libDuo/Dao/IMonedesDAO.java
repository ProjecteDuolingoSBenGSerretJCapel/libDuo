package libDuo.Dao;

public interface IMonedesDAO {

	//augmentar x monedes quan el usauri obra un cofre
	public boolean augmentarMonedes(int monedesActuals);
	
	//disminuir monedes en cas de que el usuari compri algun objecte a la tenda
	public boolean disminuirMonedes(int monedesActuals);
}
