package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.legislateur.mock.Key;
import fr.gouv.mte.capqualif.legislateur.mock.DataInExistingJsonAPI;
import fr.gouv.mte.capqualif.legislateur.mock.ParentKey;
import fr.gouv.mte.capqualif.titre.domain.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JsonExtractor {

    @Autowired
    TimeConverter timeConverter;

    public List<Map<String, String>> getWantedData(JsonElement json, DataInExistingJsonAPI dataInExistingJsonAPI, Value conditionValue) {
        JsonObject jsonPortionMatchingConditionValue = findJsonObjectByEntryValue(json, dataInExistingJsonAPI.getMainWantedKey(), conditionValue);
        return extractWantedDataFromJson(jsonPortionMatchingConditionValue, dataInExistingJsonAPI);
    }

    public JsonObject findJsonObjectByEntryValue(JsonElement jsonElement, Key mainWantedKey, Value mainWantedValue) {

        // In case you don't know: an entry is a "key:value" pair. Example : for entry "bestMeal:kebab", entry value is "kebab".

        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject) {
                    JsonObject matchingJsonObject = findMatchingJsonObject((JsonObject) element, mainWantedKey.getKeyName(), mainWantedValue);
                    if (matchingJsonObject != null) return findMatchingJsonObject((JsonObject) element, mainWantedKey.getKeyName(), mainWantedValue);
                }
            }
        }
        if (jsonElement instanceof JsonObject) {
//            return (JsonObject) jsonElement;
            return findMatchingJsonObject((JsonObject) jsonElement, mainWantedKey.getKeyName(), mainWantedValue);
        }
        return null;
    }

    private JsonObject findMatchingJsonObject(JsonObject jsonObject, String wantedKey, Value wantedValue) {
        if (jsonObject.has(wantedKey)) {
            if (hasWantedValue(jsonObject, wantedKey, wantedValue)) {
                return jsonObject;
            }
        } else {
            return findMatchingNestedJsonObject(wantedKey, wantedValue, jsonObject);
        }
        return null;
    }

    private JsonObject findMatchingNestedJsonObject(String wantedKey, Value wantedValue, JsonObject jsonObject) {
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



    private List<Map<String, String>> extractWantedDataFromJson(JsonObject json, DataInExistingJsonAPI dataInExistingJsonAPI) {
        if (json != null) {
            List<Map<String, String>> allData = new ArrayList<>();

            // Let's add the main data!
            allData.add(findEntryByWantedKey(json, dataInExistingJsonAPI.getMainWantedKey()));

            // Let's add additional data!
            if (dataInExistingJsonAPI.getAdditionalWantedKeys() != null) {
                for (Key additionalWantedKey : dataInExistingJsonAPI.getAdditionalWantedKeys()) {
                    allData.add(findEntryByWantedKey(json, additionalWantedKey));
                }
            }

            return allData;
        }
        return null;
    }

    private Map<String, String> findEntryByWantedKey(JsonObject json, Key wantedKey) {
        JsonObject source = json;
        Map<String, String> data;
        if (wantedKey.isNested()) {
            data = findNestedEntryByWantedKey(source, wantedKey);
            source = json;
        } else {
            data = createMap(json, wantedKey);
        }
        return data;
    }

    // TO DO : Rewrite to sort positionKey (make them int)
    private Map<String, String> findNestedEntryByWantedKey(JsonObject source, Key wantedKey) {
        List<ParentKey> parentKeys = wantedKey.getParentKeys();
        for (ParentKey parentKey : parentKeys) {
            for (int i = 1; i <= parentKeys.size(); i++) {
                if (parentKey.getPosition().toString().equals("POSITION_" + i) && (source.get(parentKey.getKeyName()) instanceof JsonObject)) {
                    JsonObject jsonSource = (JsonObject) source.get(parentKey.getKeyName());
                    source = jsonSource;
                }
            }
        }
        return createMap(source, wantedKey);
    }

    private Map<String, String> createMap(JsonObject source, Key wantedKey) {
        Map<String, String> data = new HashMap<>();
        data.put(wantedKey.getKeyCategory(), source.get(wantedKey.getKeyName()).getAsString());
        return data;
    }

    private boolean hasWantedValue(JsonObject jsonObject, String wantedKey, Value wantedValue) {
        if (wantedValue.getType() == "date") {
            return checkDate(jsonObject, wantedKey, wantedValue.getContent());
        }
        if (wantedValue.getType() == "string") {
            return jsonObject.get(wantedKey).getAsString().equals(wantedValue.getContent());
        }
        return false;
    }

    private boolean checkDate(JsonObject jsonObject, String wantedKey, String wantedValue) {
        LocalDate wantedDate = timeConverter.convertToLocalDate(wantedValue);
        LocalDate testedDate = timeConverter.convertToLocalDate(jsonObject.get(wantedKey).getAsString());
        return testedDate.isBefore(wantedDate);
    }
}
