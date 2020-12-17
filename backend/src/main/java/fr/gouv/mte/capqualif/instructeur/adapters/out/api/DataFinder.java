package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instructeur.adapters.out.api.mock.InfosToLookFor;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.utils.LocalJsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataFinder {

    @Autowired
    LocalJsonGetter localJsonGetter;

    @Autowired
    GetMarinDataPort getMarinDataPort;

    @Autowired
    InfosToLookFor infosToLookFor;

    public List<Map> findMatchingMarinData(String existingDataSource, String numeroDeMarin) {
        Map infos = infosToLookFor.whatInfosToLookFor(existingDataSource);
        JsonElement json = getMarinDataPort.getMarinData(infos.get("source").toString(), numeroDeMarin);
        List<Map> allMatchingData = buildMatchingDataList(infos, json);
//        Map<String, String> allMatchingData = buildMatchingDataList(infos, json);
        return allMatchingData;
    }

    private List<Map> buildMatchingDataList(Map infos, JsonElement json) {
        List<Map> matchingDataList = new ArrayList<>();
        if (json instanceof JsonObject) {
            matchingDataList.add(getMatchingData(infos, (JsonObject) json));
        } else if (json instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) json;
            for (JsonElement element : jsonArray) {
                matchingDataList.add(getMatchingData(infos, element));
            }
        }
        return matchingDataList;
    }

    // TO DO : this works for {} structure, but what if we have {{}} ?
    private Map getMatchingData(Map infos, JsonElement json) {
        Map matchingData = new HashMap();
        JsonObject jsonObject = (JsonObject) json;
        if (infos.containsKey("expirationField")) {
            String expirationField = getDataForTheField(infos, jsonObject, "expirationField");
            matchingData.put("expirationField", expirationField);
        }

        if (infos.containsKey("nestedField")) {
            JsonObject simpleField = jsonObject.get(infos.get("simpleField").toString()).getAsJsonObject();
            String nestedField = getDataForTheField(infos, simpleField, "nestedField");
            matchingData.put("nestedField", nestedField);
        } else {
            List<String> infosFromJson = new ArrayList<String>();
            String simpleField = getDataForTheField(infos, jsonObject, "simpleField");
            matchingData.put("simpleField", simpleField);
        }
        return matchingData;
    }

    private String getDataForTheField(Map infos, JsonObject jsonObject, String dataField) {
        JsonElement jsonElement = jsonObject.get(infos.get(dataField).toString());
        if (jsonElement instanceof JsonNull) {
            return "null";
        }
        return jsonElement.getAsString();
    }
}
