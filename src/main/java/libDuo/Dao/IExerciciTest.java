package libDuo.Dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.JsonElement;

import libDuo.model.ExerciciTest;

public interface IExerciciTest {
	
	public ExerciciTest setNouTipus(ArrayList<ExerciciTest> arrayExercicis, String exercici, String enunciat, String resposta1, String resposta2, String resposta3, String respostaCorrecte);
	
	public File llegirFicherJson(String ruta);
	
	public void escriureFicherJson(File file, String jsonString);
	
	public void llegirJson(File file) throws FileNotFoundException;
	
	public void dumpJsonElement(JsonElement datos);
	
	public String getJsonString(File file, ArrayList<ExerciciTest> arrayExerici);

}
