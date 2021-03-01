package fr.gouv.mte.capqualif.shared;


import com.google.gson.JsonArray;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import fr.gouv.mte.capqualif.legislateur.mock.EntryInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.KeyInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ParentKey;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Component
public class JsonExtractor {

    public List<EntryInExistingDataSource> getWantedData(String json, EntryInExistingDataSource mainWantedData,
                                                         List<KeyInExistingDataSource> additionalWantedData) {

        List<EntryInExistingDataSource> wantedData = new ArrayList<EntryInExistingDataSource>();

        if (mainWantedData.getKeyInExistingDataSource().isNested()) {
            findJsonPortionByEntry(json, mainWantedData, mainWantedData.getValue().getContent());
        }

//        EntryInExistingDataSource resultForMainWantedData =
//
//                createResult(mainWantedData.getKeyInExistingDataSource().getName(), "Apte TF/TN", DataType.STRING);

//        EntryInExistingDataSource resultForAdditionalWantedData = createResult("dateFinDeValidite", "1640905200000",
//                DataType.DATE);
//
//        wantedData.add(resultForMainWantedData);
//        wantedData.add(resultForAdditionalWantedData);

        return wantedData;
    }

    private String findJsonPortionByEntry(String json, EntryInExistingDataSource mainWantedData, String value) {
        // query example : $..codeBrevetMarin[?(@.libelle == 'Certificat de formation de base à la sécurité (STCW10)')]

        String path = buildPath(mainWantedData.getKeyInExistingDataSource().getParentKeys());
        String query = buildQuery(mainWantedData, path);
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

        JSONArray jsonPortion = JsonPath.parse(json).read(query);
//        List<String> wantedEntry = ctx.read(query);
//        JsonArray jsonPortion = ctx.read("$..codeBrevetMarin[?(@.libelle == 'Certificat de formation de base à la " +
//                "sécurité (STCW10)')]");

        System.out.println(jsonPortion);


        return null;
    }

    private String buildQuery(EntryInExistingDataSource mainWantedData, String path) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("$"); // The root element to query. This starts all path expressions.
        stringBuilder.append(".."); // Deep scan. Available anywhere a name is required.
        stringBuilder.append(path); // The key we are looking for.If the key is nested (has parents), it will be
        // something like : parent1.parent2.key
        stringBuilder.append("[?(@.");   // [? : Filter expression. Expression must evaluate to a boolean value.
        // @ : The current node being processed by a filter predicate.
        // .<name> : Dot-notated child (here, name is the variable in the next line)
        stringBuilder.append(mainWantedData.getKeyInExistingDataSource().getName());
        stringBuilder.append("=='");
        stringBuilder.append(mainWantedData.getValue().getContent());
        stringBuilder.append("'");
        stringBuilder.append(")]");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private String buildPath(List<ParentKey> parentKeys) {


//        List<ParentKey> test = Arrays.asList(new ParentKey(Position.POSITION_1, "bla"), new ParentKey(Position
//        .POSITION_2, "bli"));

        StringJoiner stringJoiner = new StringJoiner(".");

        List<ParentKey> sortedParentKeys = parentKeys.stream()
                .sorted(Comparator.comparing(ParentKey::getPosition))
                .collect(Collectors.toList());
        for (ParentKey key : sortedParentKeys) {
            System.out.println("sortedParentKeys :" + key);
            stringJoiner.add(key.getKeyName());
        }
        String path = stringJoiner.toString();
        System.out.println(path);
        return path;
    }

    private EntryInExistingDataSource createResult(String key, String value, DataType dataType) {
        return new EntryInExistingDataSource(
                new KeyInExistingDataSource(key),
                new Value(value),
                dataType
        );
    }

//
//    @Autowired
//    TimeConverter timeConverter;
//
//    // Okay, let's document this little one!
//    // What are this method's params?
//    //     - wantedEntry : The key:value pair we are looking for in the json. Ex: "libelle":"Apte TF/TN"
//    //     - keysOfAdditionalWantedData : When we don't search a predefined value, and just want to know the value
//    of a given key. Ex: "dateFinDeValidite"
//    public List<EntryInExistingDataSource> getWantedData(JsonElement json, EntryInExistingDataSource wantedEntry,
//    List<KeyInExistingDataSource> keysOfAdditionalWantedData) {
//        // Faire un truc de ce genre. Du coup le check sur le datatype devrait dégager...
//        JsonObject jsonPortionMatchingConditionValue;
//        if (wantedEntry.getValue() == null) {
//            jsonPortionMatchingConditionValue = findJsonObjectByKey(json, wantedEntry.getKeyInExistingDataSource())
//            ; // => A FAIRE
//        } else {
//            jsonPortionMatchingConditionValue = findJsonObjectByEntry(json, wantedEntry);
//        }
//        return extractWantedDataFromJson(jsonPortionMatchingConditionValue, wantedEntry, keysOfAdditionalWantedData);
//    }
//
//    // ============================ 1. Let's find the json object that contains the data we want
//    ============================
//
//    // In case you don't know: an entry is a "key:value" pair. Example: for entry "bestMeal:kebab", entry key is
//    // "bestMeal" and entry value is "kebab".
//    // Here, we are looking for a json object containing a specific entry.
//    private JsonObject findJsonObjectByEntry(JsonElement jsonElement, EntryInExistingDataSource wantedEntry) {
//        if (jsonElement instanceof JsonArray) {
//            JsonArray jsonArray = (JsonArray) jsonElement;
//            for (JsonElement element : jsonArray) {
//                if (element instanceof JsonObject) {
//                    JsonObject matchingJsonObject = findMatchingJsonObject((JsonObject) element, wantedEntry
//                    .getKeyInExistingDataSource(), wantedEntry.getValue());
//                    if (matchingJsonObject != null)
//                        return findMatchingJsonObject((JsonObject) element, wantedEntry.getKeyInExistingDataSource(),
//                                wantedEntry.getValue());
//                }
//            }
//        }
//        if (jsonElement instanceof JsonObject) {
//            return findMatchingJsonObject((JsonObject) jsonElement, wantedEntry.getKeyInExistingDataSource(),
//            wantedEntry.getValue());
//        }
//        return null;
//    }
//
//    private JsonObject findJsonObjectByKey(JsonElement jsonElement, KeyInExistingDataSource key) {
//        // FAIRE
//        return null;
//    }
//
//    private JsonObject findMatchingJsonObject(JsonObject jsonObject, KeyInExistingDataSource wantedKey, Value
//    wantedValue) {
//        if (jsonObject.has(wantedKey.getName())) {
//            if (hasWantedValue(jsonObject, wantedKey, wantedValue)) {
//                return jsonObject;
//            }
//        } else {
//            return findMatchingNestedJsonObject(jsonObject, wantedKey, wantedValue);
//        }
//        return null;
//    }
//
//    private JsonObject findMatchingNestedJsonObject(JsonObject jsonObject, KeyInExistingDataSource wantedKey, Value
//    wantedValue) {
//        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
//            if (entry.getValue() instanceof JsonObject) {
//                JsonObject nestedJsonObject = (JsonObject) entry.getValue();
//                if (nestedJsonObject.has(wantedKey.getName())) {
//                    if (hasWantedValue(nestedJsonObject, wantedKey, wantedValue)) {
//                        return jsonObject;
//                    } else {
//                        findMatchingNestedJsonObject(nestedJsonObject, wantedKey, wantedValue);
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private boolean hasWantedValue(JsonObject jsonObject, KeyInExistingDataSource wantedKey, Value wantedValue) {
//        if (wantedKey.getDataType().equals(DataType.DATE)) {
//            return checkDate(jsonObject, wantedKey.getName(), wantedValue.getContent());
//        }
//        if (wantedKey.getDataType().equals(DataType.STRING)) {
//            return jsonObject.get(wantedKey.getName()).getAsString().equals(wantedValue.getContent());
//        }
//        return false;
//    }
//
//    private boolean checkDate(JsonObject jsonObject, String wantedKey, String wantedValue) {
//        LocalDate wantedDate = timeConverter.convertToLocalDate(wantedValue);
//        LocalDate testedDate = timeConverter.convertToLocalDate(jsonObject.get(wantedKey).getAsString());
//        return testedDate.isBefore(wantedDate); // et si on cherche une date after ?
//    }
//
//    // ============================== End of step 1 =============================================
//
//    // ============================ 2. Let's extract all the data we want ============================
//
//    private List<EntryInExistingDataSource> extractWantedDataFromJson(JsonObject json,
//                                                  EntryInExistingDataSource entry, List<KeyInExistingDataSource>
//                                                  keysOfAdditionalWantedData) {
//        if (json != null) {
//            List<EntryInExistingDataSource> allData = new ArrayList<EntryInExistingDataSource>();
//
//            // Let's add the main data!
//            allData.add(findEntryByWantedKey(json, entry.getKeyInExistingDataSource()));
//
//            // Let's add additional data!
//            if (keysOfAdditionalWantedData != null) {
//                for (KeyInExistingDataSource key :
//                        keysOfAdditionalWantedData) {
//                    allData.add(findEntryByWantedKey(json, key));
//                }
//            }
//
//            return allData;
//        }
//        return Collections.emptyList();
//    }
//
//    private EntryInExistingDataSource findEntryByWantedKey(JsonObject json, KeyInExistingDataSource key) {
//        JsonObject source = json;
//        EntryInExistingDataSource entry;
//        if (key.isNested()) {
//            entry = findNestedEntryByWantedKey(source, key);
//            source = json;
//        } else {
//            entry = createEntry(json, key.getName(), key.getDataType());
//        }
//        return entry;
//    }
//
//    // TO DO : Rewrite to sort positionKey (make them int)
//    private EntryInExistingDataSource findNestedEntryByWantedKey(JsonObject source, KeyInExistingDataSource key) {
//        List<ParentKey> parentKeys = key.getParentKeys();
//        for (ParentKey parentKey : parentKeys) {
//            for (int i = 1; i <= parentKeys.size(); i++) {
//                if (parentKey.getPosition().toString().equals("POSITION_" + i) && (source.get(parentKey
//                .getKeyRealNameInExistingDataSource()) instanceof JsonObject)) {
//                    JsonObject jsonSource = (JsonObject) source.get(parentKey.getKeyRealNameInExistingDataSource());
//                    source = jsonSource;
//                }
//            }
//        }
//        return createEntry(source, key.getName(), key.getDataType());
//    }
//
//    private EntryInExistingDataSource createEntry(JsonObject source, String key, DataType valueType) {
//        Value value =
//                new Value(source.get(key).getAsString());
//        EntryInExistingDataSource entry = new EntryInExistingDataSource(new KeyInExistingDataSource(key), value,
//        valueType);
//        return entry;
//    }
//
//
//    // ============================== End of step 2 =============================================
}
