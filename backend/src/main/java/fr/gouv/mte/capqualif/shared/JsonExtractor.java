package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.legislateur.mock.Key;
import fr.gouv.mte.capqualif.legislateur.mock.DataToSearchForInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ParentKey;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class JsonExtractor {

    @Autowired
    TimeConverter timeConverter;

    public List<Entry> getWantedData(JsonElement json, Value conditionValue, DataToSearchForInExistingDataSource dataToSearchForInExistingDataSource) {
        JsonObject jsonPortionMatchingConditionValue = findJsonObjectByEntryValue(json, conditionValue, dataToSearchForInExistingDataSource.getKeyOfMainWantedData());
        return extractWantedDataFromJson(jsonPortionMatchingConditionValue, dataToSearchForInExistingDataSource);
    }

    // TO DO : peut être que je peux remplacer Value valueOfMainWantedData, Key keyOfMainWantedData par l'objet Entry ?
    public JsonObject findJsonObjectByEntryValue(JsonElement jsonElement, Value valueOfMainWantedData, Key keyOfMainWantedData) {

        // In case you don't know: an entry is a "key:value" pair. Example : for entry "bestMeal:kebab", entry value is "kebab".

        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject) {
                    JsonObject matchingJsonObject = findMatchingJsonObject((JsonObject) element, keyOfMainWantedData.getKeyRealNameInExistingDataSource(), valueOfMainWantedData);
                    if (matchingJsonObject != null) return findMatchingJsonObject((JsonObject) element, keyOfMainWantedData.getKeyRealNameInExistingDataSource(), valueOfMainWantedData);
                }
            }
        }
        if (jsonElement instanceof JsonObject) {
//            return (JsonObject) jsonElement;
            return findMatchingJsonObject((JsonObject) jsonElement, keyOfMainWantedData.getKeyRealNameInExistingDataSource(), valueOfMainWantedData);
        }
        return null;
    }

    private JsonObject findMatchingJsonObject(JsonObject jsonObject, String wantedKey, Value wantedValue) {
        if (jsonObject.has(wantedKey)) {
            if (hasWantedValue(jsonObject, wantedKey, wantedValue)) {
                return jsonObject;
            }
        } else {
            return findMatchingNestedJsonObject(jsonObject, wantedKey, wantedValue);
        }
        return null;
    }

    private JsonObject findMatchingNestedJsonObject(JsonObject jsonObject, String wantedKey, Value wantedValue) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            if (entry.getValue() instanceof JsonObject) {
                JsonObject nestedJsonObject = (JsonObject) entry.getValue();
                if (nestedJsonObject.has(wantedKey)) {
                    if (hasWantedValue(nestedJsonObject, wantedKey, wantedValue)) {
                        return jsonObject;
                    } else {
                        findMatchingNestedJsonObject(nestedJsonObject, wantedKey, wantedValue);
                    }
                }
            }
        }
        return null;
    }

    private boolean hasWantedValue(JsonObject jsonObject, String wantedKey, Value wantedValue) {
        if (wantedValue.getType() == DataType.DATE) {
            return checkDate(jsonObject, wantedKey, wantedValue.getContent());
        }
        if (wantedValue.getType() == DataType.STRING) {
            return jsonObject.get(wantedKey).getAsString().equals(wantedValue.getContent());
        }
        return false;
    }


    private List<Entry> extractWantedDataFromJson(JsonObject json, DataToSearchForInExistingDataSource dataToSearchForInExistingDataSource) {
        if (json != null) {
            List<Entry> allData = new ArrayList<Entry>();

            // Let's add the main data!
            allData.add(findEntryByWantedKey(json, dataToSearchForInExistingDataSource.getKeyOfMainWantedData()));

            // Let's add additional data!
            if (dataToSearchForInExistingDataSource.getKeysOfAdditionnalWantedData() != null) {
                for (Key keyOfAdditionnalWantedData : dataToSearchForInExistingDataSource.getKeysOfAdditionnalWantedData()) {
                    allData.add(findEntryByWantedKey(json, keyOfAdditionnalWantedData));
                }
            }

            return allData;
        }
        return Collections.emptyList();
    }

    private Entry findEntryByWantedKey(JsonObject json, Key wantedKey) {
        JsonObject source = json;
        Entry entry;
        if (wantedKey.isNested()) {
            entry = findNestedEntryByWantedKey(source, wantedKey);
            source = json;
        } else {
            entry = createEntry(json, wantedKey);
        }
        return entry;
    }

    // TO DO : Rewrite to sort positionKey (make them int)
    private Entry findNestedEntryByWantedKey(JsonObject source, Key wantedKey) {
        List<ParentKey> parentKeys = wantedKey.getParentKeys();
        for (ParentKey parentKey : parentKeys) {
            for (int i = 1; i <= parentKeys.size(); i++) {
                if (parentKey.getPosition().toString().equals("POSITION_" + i) && (source.get(parentKey.getKeyRealNameInExistingDataSource()) instanceof JsonObject)) {
                    JsonObject jsonSource = (JsonObject) source.get(parentKey.getKeyRealNameInExistingDataSource());
                    source = jsonSource;
                }
            }
        }
        return createEntry(source, wantedKey);
    }

    private Entry createEntry(JsonObject source, Key wantedKey) {
        Value value = new Value(source.get(wantedKey.getKeyRealNameInExistingDataSource()).getAsString(), wantedKey.getTypeOfAssociatedValue());
        Entry entry = new Entry(wantedKey.getKeyRealNameInExistingDataSource(), value);
        return entry;
    }

    private boolean checkDate(JsonObject jsonObject, String wantedKey, String wantedValue) {
        LocalDate wantedDate = timeConverter.convertToLocalDate(wantedValue);
        LocalDate testedDate = timeConverter.convertToLocalDate(jsonObject.get(wantedKey).getAsString());
        return testedDate.isBefore(wantedDate);
    }
}
