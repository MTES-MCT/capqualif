package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.legislateur.mock.InfosToLookFor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private InfosToLookFor infosToLookFor;

    public JsonElement getMarinData(String numeroDeMarin) {
        Map infos = infosToLookFor.whatInfosToLookFor("item");
        JsonElement allMarinData = getJson(numeroDeMarin, infos.get("source").toString());
//        List<JsonObject> matchingJsonObjects = findMatchingJsonObjects(allMarinData, infos.get("simpleField").toString());

        return null;
    }

    private JsonElement getJson(String numeroDeMarin, String existingDataSource) {

        // TO DO : convert numeroDeMarin to ID_ADMINISTRE

//        String request = existingDataSource + numeroDeMarin;
//        System.out.println("Looking for " + request);

//        For MOCKY :
        String request = existingDataSource;
        System.out.println("Looking for " + request);

        String res = restTemplate.getForObject(request, String.class);
        Gson gson = new Gson();
        JsonElement json = gson.fromJson(res, JsonElement.class);
        return json;
    }

    public void dumb() {
//        JsonElement jsonElement = getAllData("123", "https://run.mocky.io/v3/6cb166af-401d-4358-ad28-f71ffc4d448c");
//        JsonElement jsonElement = getAllData("123", "https://run.mocky.io/v3/4f683454-5dda-41de-8864-f0114161b2f0");
//        findMatchingJsonObjects(jsonElement, "libelleModuleUv", "P3–Appui-Exploitation/assist/entretien/répar");
        JsonElement jsonElement = getJson("123", "https://run.mocky.io/v3/86517f52-2fe6-4bb3-a786-14561dae7f68");
        findMatchingJsonObjects(jsonElement, "rendezVous", "123");
    }

    private void findMatchingJsonObjects(JsonElement jsonElement, String wantedKey, String wantedValue) {
        List<JsonObject> matchingJsonObjects = new ArrayList<JsonObject>();
//        System.out.println("********* Input json element *********");
//        System.out.println(jsonElement);
        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject) {
                    searchInJsonObject((JsonObject) element, wantedKey, wantedValue, matchingJsonObjects);
                }
            }
        } else if (jsonElement instanceof JsonObject) {
            searchInJsonObject((JsonObject) jsonElement, wantedKey, wantedValue, matchingJsonObjects);
        }
    }

    private void searchInJsonObject(JsonObject jsonElement, String wantedKey, String wantedValue, List<JsonObject> matchingJsonObjects) {
        JsonObject jsonObject = jsonElement;
        if (jsonObject.has(wantedKey)) {
            if (jsonObject.get(wantedKey).getAsString().equals(wantedValue)) {
                System.out.println("********* Wanted element *********");
                System.out.println(jsonObject);
                matchingJsonObjects.add(jsonObject);
            }
        } else {
            scanNestedJsonObjects(wantedKey, wantedValue, matchingJsonObjects, jsonObject);
        }
    }

    private void scanNestedJsonObjects(String wantedKey, String wantedValue, List<JsonObject> matchingJsonObjects, JsonObject jsonObject) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            if (entry.getValue() instanceof JsonObject) {
                JsonObject nestedJsonObject = (JsonObject) entry.getValue();
                if (nestedJsonObject.has(wantedKey)) {
                    if (nestedJsonObject.get(wantedKey).getAsString().equals(wantedValue)) {
                        System.out.println("****** nested object wanted key *********");
                        System.out.println(nestedJsonObject.get(wantedKey));
                        System.out.println(jsonObject);
                        matchingJsonObjects.add(jsonObject);
                    } else {
                        scanNestedJsonObjects(wantedKey, wantedValue, matchingJsonObjects, nestedJsonObject);
                    }
                }
            }
        }
    }

    @Override
    public JsonElement getMarinData(Map infosToLookFor, String numeroDeMarin) {
        return null;
    }

//    private void getNeededData(JsonObject jsonObject) {
//
//    }

}
