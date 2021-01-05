package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.legislateur.mock.Key;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataInfos;
import fr.gouv.mte.capqualif.legislateur.mock.ParentKey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JsonExtractor {

    public JsonObject findMatchingJson(JsonElement jsonElement, String mainWantedKey, String mainWantedValue) {
        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject) {
                    if (findMatchingJsonObject((JsonObject) element, mainWantedKey, mainWantedValue) != null) {
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
                        return jsonObject;
                    } else {
                        findMatchingNestedJsonObject(wantedKey, wantedValue, nestedJsonObject);
                    }
                }
            }
        }
        return null;
    }

    public List<Map<String, String>> getAllAdditionalData(JsonObject json, ExistingDataInfos existingDataInfos) {
        List<Map<String, String>> allAdditionalData = new ArrayList<>();
        JsonObject source = json;
        for (Key additionalWantedKey : existingDataInfos.getAdditionalWantedKeys()) {
            if (additionalWantedKey.isNested()) {
                Map<String, String> data = getNestedData(source, additionalWantedKey);
                System.out.println(data);
                allAdditionalData.add(data);
                // Reset json source
                source = json;
            } else {
                Map<String, String> data = new HashMap<>();
                data.put(additionalWantedKey.getKeyName(), json.get(additionalWantedKey.getKeyName()).getAsString());
//                System.out.println(additionalWantedKey.getKeyValue());
                System.out.println(data);
                allAdditionalData.add(data);
            }
        }
        System.out.println(allAdditionalData);
        return allAdditionalData;
    }

    // TO DO : Rewrite
    private Map<String, String> getNestedData(JsonObject source, Key additionalWantedKey) {
        List<ParentKey> parentKeys = additionalWantedKey.getParentKeys();
        for (ParentKey parentKey : parentKeys) {
            for (int i = 1; i <= parentKeys.size(); i++) {
                if (parentKey.getPosition().toString().equals("POSITION_" + i) && (source.get(parentKey.getKeyName()) instanceof JsonObject)) {
                    JsonObject jsonSource = (JsonObject) source.get(parentKey.getKeyName());
                    source = jsonSource;
                }
            }
        }
        Map<String, String> data = new HashMap<>();
        data.put(additionalWantedKey.getKeyName(), source.get(additionalWantedKey.getKeyName()).getAsString());
        return data;
//        return source.get(additionalWantedKey.getKeyValue()).getAsString();
    }


    private boolean hasWantedValue(JsonObject jsonObject, String wantedKey, String wantedValue) {
        return jsonObject.get(wantedKey).getAsString().equals(wantedValue);
    }
}
