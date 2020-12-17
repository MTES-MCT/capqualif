package fr.gouv.mte.capqualif.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Component
public class LocalJsonGetter {

    public JsonArray getJson(String resource) {
        JsonArray jsonArray = buildJson(resource);
        return jsonArray;
    }

    private JsonArray buildJson(String resource) {
        String json = fromStreamToString(resource);
        System.out.println(json);
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(json, JsonArray.class);
        return jsonArray;
    }

    private String fromStreamToString(String resource) {
        InputStream stream = loadResource(resource);
        InputStreamReader inputReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        String json = bufferedReader.lines().collect(Collectors.joining("\n"));
        return json;
    }

    private InputStream loadResource(String resource) {
        try {
            InputStream stream = new ClassPathResource(resource).getInputStream();
            return stream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
