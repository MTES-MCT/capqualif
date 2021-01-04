package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
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


    public List<Map<String, String>> getAllWantedData(JsonObject json, ExistingDataInfos existingDataInfos) {
        JsonObject source = json;
        for (Key additionalWantedKey : existingDataInfos.getAdditionalWantedKeys()) {
            if (additionalWantedKey.isNested()) {
                String nestedKeyValue = getNestedKeyValue(source, additionalWantedKey);
                System.out.println(nestedKeyValue);
                // Reset json source
                source = json;
            } else {
                System.out.println(additionalWantedKey.getKeyValue());
            }
        }
        return null;
    }

    private String getNestedKeyValue(JsonObject source, Key additionalWantedKey) {
        List<ParentKey> parentKeys = additionalWantedKey.getParentKeys();
        for (ParentKey parentKey : parentKeys) {
            for (int i = 1; i <= parentKeys.size(); i++) {
                if (parentKey.getPosition().toString().equals("POSITION_" + i) && (source.get(parentKey.getKeyName()) instanceof JsonObject)) {
                    JsonObject jsonSource = (JsonObject) source.get(parentKey.getKeyName());
                    source = jsonSource;
                }
            }
        }
        return source.get(additionalWantedKey.getKeyValue()).getAsString();
    }


    private boolean hasWantedValue(JsonObject jsonObject, String wantedKey, String wantedValue) {
        return jsonObject.get(wantedKey).getAsString().equals(wantedValue);
    }
}
