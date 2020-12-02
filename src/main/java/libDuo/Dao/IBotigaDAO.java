package libDuo.Dao;

public interface IBotigaDAO {

	//Et permet mantenir la teva racha quan no juguis per un dia
	public boolean protectorDeRachas();
	
	//duplica la teva aposta de 50 gemas al mantenir la racha durant 7 dies
	public boolean dobleONada();
	
	//recarga el set de vidas i augmenta les posibilitats de acabar una llico
	public boolean setDeVidas();
	
	//Comprar un traje per le teu avatar amb monedes
	public boolean comprarTraje();
}
