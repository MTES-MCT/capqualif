package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JsonExtractor {

    public JsonObject findMatchingJson(JsonElement jsonElement, String mainWantedKey, String mainWantedValue) {
        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject) {
                    if(findMatchingJsonObject((JsonObject) element, mainWantedKey, mainWantedValue) != null) {
                        return findMatchingJsonObject((JsonObject) element, mainWantedKey, mainWantedValue);
                    }
                }
            }
        } else if (jsonElement instanceof JsonObject) {
            return findMatchingJsonObject((JsonObject) jsonElement, mainWantedKey, mainWantedValue);
        }
        return null;
    }

    private JsonObject findMatchingJsonObject(JsonObject jsonObject, String wantedKey, String wantedValue) {
        if (jsonObject.has(wantedKey)) {
            if (hasWantedValue(jsonObject, wantedKey, wantedValue)) {
                System.out.println("********* Wanted element *********");
                System.out.println(jsonObject);
                return jsonObject;
            }
        } else {
            return findMatchingNestedJsonObject(wantedKey, wantedValue, jsonObject);
        }
        return null;
    }

    private JsonObject findMatchingNestedJsonObject(String wantedKey, String wantedValue, JsonObject jsonObject) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            if (entry.getValue() instanceof JsonObject) {
                JsonObject nestedJsonObject = (JsonObject) entry.getValue();
                if (nestedJsonObject.has(wantedKey)) {
                    if (hasWantedValue(nestedJsonObject, wantedKey, wantedValue)) {
//                        System.out.println("****** Nested wanted element *********");
//                        System.out.println(jsonObject);
                        return jsonObject;
                    } else {
                        findMatchingNestedJsonObject(wantedKey, wantedValue, nestedJsonObject);
                    }
                }
            }
        }
        return null;
    }


    public List<Map<String, String>> getAllWantedData(JsonObject json, Map<String, List> wantedData) {
      List<Map<String, String>> additionalWantedKeys = wantedData.get("additionalWantedKeys".toString());
      for (Map<String, String> keyMap : additionalWantedKeys) {
          json.get(keyMap.get())
          return null;
      }
      return null;
    };


    private boolean hasWantedValue(JsonObject jsonObject, String wantedKey, String wantedValue) {
        return jsonObject.get(wantedKey).getAsString().equals(wantedValue);
    }
}
