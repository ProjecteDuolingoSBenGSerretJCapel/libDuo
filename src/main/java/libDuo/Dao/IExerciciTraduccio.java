package libDuo.Dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.JsonElement;

import libDuo.model.ExerciciTest;
import libDuo.model.ExerciciTraduccio;

public interface IExerciciTraduccio {

	

	void dumpJsonElement(JsonElement datos,ArrayList<String> jsonArrayList);

	void llegirJson(File file) throws FileNotFoundException;

	void escriureFicherJson(File file, String jsonString);

	File llegirFicherJson(String ruta);

	ExerciciTraduccio setNouTipus(ArrayList<ExerciciTraduccio> arrayExercicis, String tipusExercici, String fraseOrigen,
			ArrayList<String> respostesCorrectes);

	String getJsonString(File file, ArrayList<ExerciciTraduccio> arrayExerici);
	
	public ArrayList<String> getArrayList(); 
}
