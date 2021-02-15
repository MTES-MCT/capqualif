package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.legislateur.mock.DataToExtractFromExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.KeyInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ParentKey;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class JsonExtractor {

    @Autowired
    TimeConverter timeConverter;

    public List<Entry> getWantedData(JsonElement json, Value conditionValue,
                                     DataToExtractFromExistingDataSource dataToExtractFromExistingDataSource) {
        JsonObject jsonPortionMatchingConditionValue = findJsonObjectByEntry(json,
                new Entry(dataToExtractFromExistingDataSource.getKeyOfMainWantedData().getKeyRealNameInExistingDataSource(), conditionValue)
        );
        return extractWantedDataFromJson(jsonPortionMatchingConditionValue, dataToExtractFromExistingDataSource);
    }

    // ============================ 1. Let's find the json object that contains the data we want ============================

    public JsonObject findJsonObjectByEntry(JsonElement jsonElement, Entry wantedEntry) {

        // In case you don't know: an entry is a "key:value" pair. Example : for entry "bestMeal:kebab", entry key is
        // "bestMeal" and entry value is "kebab".
        // Here, we are looking for a json object containing a specific entry

        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) jsonElement;
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject) {
                    JsonObject matchingJsonObject = findMatchingJsonObject((JsonObject) element, wantedEntry.getKey(), wantedEntry.getValue());
                    if (matchingJsonObject != null)
                        return findMatchingJsonObject((JsonObject) element, wantedEntry.getKey(),
                                wantedEntry.getValue());
                }
            }
        }
        if (jsonElement instanceof JsonObject) {
            return findMatchingJsonObject((JsonObject) jsonElement, wantedEntry.getKey(), wantedEntry.getValue());
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

    private boolean checkDate(JsonObject jsonObject, String wantedKey, String wantedValue) {
        LocalDate wantedDate = timeConverter.convertToLocalDate(wantedValue);
        LocalDate testedDate = timeConverter.convertToLocalDate(jsonObject.get(wantedKey).getAsString());
        return testedDate.isBefore(wantedDate);
    }

    // ============================== End of step 1 =============================================

    // ============================ 2. Let's extract all the data we want ============================

    private List<Entry> extractWantedDataFromJson(JsonObject json,
                                                  DataToExtractFromExistingDataSource dataToExtractFromExistingDataSource) {
        if (json != null) {
            List<Entry> allData = new ArrayList<Entry>();

            // Let's add the main data!
            allData.add(findEntryByWantedKey(json, dataToExtractFromExistingDataSource.getKeyOfMainWantedData()));

            // Let's add additional data!
            if (dataToExtractFromExistingDataSource.getKeysOfAdditionnalWantedData() != null) {
                for (KeyInExistingDataSource keyInExistingDataSourceOfAdditionalWantedData :
                        dataToExtractFromExistingDataSource.getKeysOfAdditionnalWantedData()) {
                    allData.add(findEntryByWantedKey(json, keyInExistingDataSourceOfAdditionalWantedData));
                }
            }

            return allData;
        }
        return Collections.emptyList();
    }

    private Entry findEntryByWantedKey(JsonObject json, KeyInExistingDataSource wantedKeyInExistingDataSource) {
        JsonObject source = json;
        Entry entry;
        if (wantedKeyInExistingDataSource.isNested()) {
            entry = findNestedEntryByWantedKey(source, wantedKeyInExistingDataSource);
            source = json;
        } else {
            entry = createEntry(json, wantedKeyInExistingDataSource);
        }
        return entry;
    }

    // TO DO : Rewrite to sort positionKey (make them int)
    private Entry findNestedEntryByWantedKey(JsonObject source, KeyInExistingDataSource wantedKeyInExistingDataSource) {
        List<ParentKey> parentKeys = wantedKeyInExistingDataSource.getParentKeys();
        for (ParentKey parentKey : parentKeys) {
            for (int i = 1; i <= parentKeys.size(); i++) {
                if (parentKey.getPosition().toString().equals("POSITION_" + i) && (source.get(parentKey.getKeyRealNameInExistingDataSource()) instanceof JsonObject)) {
                    JsonObject jsonSource = (JsonObject) source.get(parentKey.getKeyRealNameInExistingDataSource());
                    source = jsonSource;
                }
            }
        }
        return createEntry(source, wantedKeyInExistingDataSource);
    }

    private Entry createEntry(JsonObject source, KeyInExistingDataSource wantedKeyInExistingDataSource) {
        Value value =
                new Value(source.get(wantedKeyInExistingDataSource.getKeyRealNameInExistingDataSource()).getAsString(), wantedKeyInExistingDataSource.getTypeOfAssociatedValue());
        Entry entry = new Entry(wantedKeyInExistingDataSource.getKeyRealNameInExistingDataSource(), value);
        return entry;
    }


    // ============================== End of step 2 =============================================
}
