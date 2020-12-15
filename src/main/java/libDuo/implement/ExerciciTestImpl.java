package libDuo.implement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import libDuo.Dao.IExerciciTest;
import libDuo.model.ExerciciTest;
import libDuo.model.LlistatExercicis;

public class ExerciciTestImpl implements IExerciciTest{

	@Override
	public File llegirFicherJson(String ruta) {
		File file = new File(ruta);
		if(file.exists()) {
			return file;
		}
		else {
			return null;
		}	
	}

	@Override
	public void escriureFicherJson(File file, String jsonString) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(jsonString);
			
			bw.close();
		} catch (IOException e) {
			System.out.println("error");
		}
	}

	@Override
	public void llegirJson(File file) throws FileNotFoundException {
		JsonParser parse = new JsonParser();
		FileReader fr = new FileReader(file);
		JsonElement datos = parse.parse(fr);
		dumpJsonElement(datos);
	}

	@Override
	public void dumpJsonElement(JsonElement datos) {
		if(datos.isJsonObject()) {
			// Es un conjunto de pares clave, valor
	        // Para cada par, imprimir la clave y llamar a dumpJSONElement(valor)
			
			//System.out.println("Es un objecte");
			JsonObject obj = datos.getAsJsonObject();
			java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
			java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
			
			while(iter.hasNext()) {
				java.util.Map.Entry<String,JsonElement> entrada = iter.next();
				System.out.println("'" + entrada.getKey() + "' : ");
				dumpJsonElement(entrada.getValue());
			}
		}
		else if(datos.isJsonArray()) {
			// Es un conjunto de valores, que pueden ser elementos simples o compuestos
	        // Para cada valor, llamar a dumpJSONElemento(valor)
			System.out.println("[");
			JsonArray array = datos.getAsJsonArray();
			//System.out.println("Es array. numero de elementos: " + array.size());
			java.util.Iterator<JsonElement> iter = array.iterator();
			while(iter.hasNext()) {
				JsonElement entrada = iter.next();
				dumpJsonElement(entrada);
			}
			System.out.println("]");
		}
		else if(datos.isJsonPrimitive()) {
			// Es un elemento simple. Determinar si se trata de un valor booleano,
	        // un n�mero o cadena de texto
			
			//System.out.println("Es primitiva");
			
			JsonPrimitive valor = datos.getAsJsonPrimitive();
			if(valor.isBoolean()) {
				System.out.println(valor.getAsBoolean());
			}
			else if(valor.isNumber()) {
				System.out.println(valor.getAsNumber());
			}
			else if(valor.isString()) {
				System.out.println(valor.getAsString());
			}
		}
		else if(datos.isJsonNull()) {
			System.out.println("null");
		}
		else {
			System.out.println("es otra cosa");
		}
		
	}

	@Override
	public ExerciciTest setNouTipus(ArrayList<ExerciciTest> arrayExercicis, String exercici, String enunciat, String resposta1, String resposta2,
			String resposta3, String respostaCorrecte) {
		ExerciciTest ex = new ExerciciTest(exercici, enunciat, resposta1, resposta2, resposta3, respostaCorrecte);
			
		arrayExercicis.add(ex);
			
		return ex;

	}

	@Override
	public String getJsonString(File file, ArrayList<ExerciciTest> arrayExerici) {
		Gson gson = new Gson();
		LlistatExercicis exercicis = new LlistatExercicis(arrayExerici);
		String jsonString2 = gson.toJson(exercicis);
		
		return jsonString2;
	}

	

}
