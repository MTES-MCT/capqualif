package fr.gouv.mte.capqualif.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class JsonReader {

    public JsonArray readJson(String file) {
        File jsonFile = loadFile(file);
        FileReader inputReader = null;
        try {
            inputReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(bufferedReader, JsonArray.class);

        return jsonArray;
    }

    private File loadFile(String file) {
        ClassLoader classLoader = getClass().getClassLoader();
        File jsonFile = new File(classLoader.getResource(file).getFile());
        System.out.println(jsonFile.getAbsolutePath());
        return jsonFile;
    }
}
