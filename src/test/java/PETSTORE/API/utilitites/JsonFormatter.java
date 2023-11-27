package PETSTORE.API.utilitites;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import PETSTORE.API.payload.PL_Store;

public class JsonFormatter {

	public static String formatJson(String payload) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonBody = gson.toJson(payload);
		    return gson.toJson(jsonBody);
	}

}
