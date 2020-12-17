package libDuo.model;

import java.util.ArrayList;

public class ExerciciTraduccio {
	
	private String tipusExercici;
	private String fraseOrigen;
	private ArrayList <String> respostesCorrectes;
	
	ArrayList respostesPossibles = new ArrayList();
	
	public ExerciciTraduccio() {
		
	}

	public ExerciciTraduccio(String tipusExercici, String fraseOrigen, ArrayList<String> respostesCorrectes) {
		super();
		this.tipusExercici = tipusExercici;
		this.fraseOrigen = fraseOrigen;
		this.respostesCorrectes = respostesCorrectes;
		for (String string : respostesCorrectes) {
			respostesPossibles.add(string);
		}
		
	}
	
}
