package libDuo.Dao;

public interface ITipusExerciciDAO {
	
	//exercici de traduir les paraules 
	public void traduccioOberta();
	
	//exercici traduir paraules mitjancant ordenant les paraules
	public void traduccioReordenaParaules();
	
	//exercici de ordena mitjanacant el audio del listening
	public void listeningReordena();
	
	//exercici de escriure la paruala segons el que digi la veu
	public void listeningObert();
	
	//exercici de aparella paraules amb els dos idiomes
	public void aparellaParaules();
	
	//exercici de omplir un espai buit amb una paraula
	public void ompleUnaParaula();
	
	//exercici tipu test
	public void tipusTest();
}
