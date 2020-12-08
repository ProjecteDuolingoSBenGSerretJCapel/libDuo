package libDuo.model;



import java.util.ArrayList;

public class Exercici {
	
	private String tipusExercici;
	private String enunciat;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private String respostaCorrecta;
	
	ArrayList respostesPossibles = new ArrayList();
	
	public Exercici(String exercici, String enunciat, String resposta1, String resposta2, String resposta3, String respostaCorrecta) {
		this.tipusExercici = exercici;
		this.enunciat = enunciat;
		
		respostesPossibles.add(resposta1);
		respostesPossibles.add(resposta2);
		respostesPossibles.add(resposta3);
		
		this.respostaCorrecta = respostaCorrecta;
	}

}
