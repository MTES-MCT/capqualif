package fr.gouv.mte.capqualif.shared;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Component
public class LocalJsonGetter {

    public JsonElement getJson(String resource) throws IOException {
        return buildJson(resource);
    }

    private JsonElement buildJson(String resource) throws IOException {
        String json = fromStreamToString(resource);
        Gson gson = new Gson();
        return gson.fromJson(json, JsonElement.class);
    }

    private String fromStreamToString(String resource) throws IOException {
        InputStream stream = loadResource(resource);
        InputStreamReader inputReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        return bufferedReader.lines().collect(Collectors.joining("\n"));
    }

    private InputStream loadResource(String resource) throws IOException {
        return new ClassPathResource(resource).getInputStream();
    }
}
