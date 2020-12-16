package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

//    public List<String> findMatchingMarinData(String existingDataSource, String sailorNumber) {
//        List<String> data = getData(existingDataSource, sailorNumber);
//        return data;
//    }

    public List<String> findMatchingMarinData(String existingDataSource, String numeroDeMarin) {

        Map infos = whatInfosToLookFor(existingDataSource);

        JsonElement json = getMarinDataPort.getMarinData(infos.get("source").toString(), numeroDeMarin);

        ArrayList allMatchingData = new ArrayList();

        if (json!=null) {
            if (json instanceof JsonObject) {
                allMatchingData = processJsonObject(infos, (JsonObject) json, allMatchingData);
            } else if (json instanceof JsonArray) {
                JsonArray jsonArray = (JsonArray) json;
                for (JsonElement element : jsonArray) {
                    allMatchingData = processJsonObject(infos, element, allMatchingData);
                }
            }
        }
        return allMatchingData;
    }

    // TO DO : this works for {} structure, but what if we have {{}} ?
    private ArrayList processJsonObject(Map infos, JsonElement json, ArrayList allMatchingData) {
        JsonObject jsonObject = (JsonObject) json;
        if (!infos.containsKey("nestedField")) {
            String field = jsonObject.get(infos.get("field").toString()).getAsString();
            allMatchingData.add(field);
            return allMatchingData;
        }
        JsonObject field = jsonObject.get(infos.get("field").toString()).getAsJsonObject();
        String subfield = field.get(infos.get("nestedField").toString()).getAsString();
        allMatchingData.add(subfield);
        return allMatchingData;
    }

    // TO DO : in the future, this infos will be built in the DAM module
    private Map whatInfosToLookFor(String existingDataSource) {
        HashMap<String, String> infos = new HashMap<>();
        switch(existingDataSource) {
            case("dumbSource"):
                infos.put("source", "https://jsonplaceholder.typicode.com/posts");
                infos.put("field", "title");
                return infos;
            case("administres"):
//                infos.put("source", "https://run.mocky.io/v3/3239b396-a0d5-4d55-9ac7-e2c19cf7e46b");
                infos.put("source", "***REMOVED******REMOVED***");
                infos.put("field", "decisionMedicale");
                infos.put("nestedField", "libelle");
                return infos;

            case("esculape"):
//                infos.put("source", "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/");
                infos.put("source", "https://run.mocky.io/v3/3239b396-a0d5-4d55-9ac7-e2c19cf7e46b");
//                infos.put("source", "https://jsonplaceholder.typicode.com/todos/1");
                infos.put("field", "decisionMedicale");
                infos.put("nestedField", "libelle");
                return infos;
            case("amfore"):
//                return "amfore.json";
        }
        return null;
    }
}
