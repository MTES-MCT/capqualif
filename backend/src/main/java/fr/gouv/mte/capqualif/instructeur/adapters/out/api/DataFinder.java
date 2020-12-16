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
                // Marin de moins de 16 ans
                infos.put("source", "https://run.mocky.io/v3/b33b5c2f-0c95-46c1-ac8d-a33b918f0bac");

                // Marin de plus de 16 ans
//                infos.put("source", "https://run.mocky.io/v3/d05d9429-48e4-4785-a8a4-b353de3d94da");

                // Vraie source
//                infos.put("source", "***REMOVED******REMOVED***");

                infos.put("field", "dateNaissance");
                return infos;
            case("esculape"):
                // Vraie source
//                infos.put("source", "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/");

                // Marin apte
//                infos.put("source", "https://run.mocky.io/v3/1957dab6-73e3-49db-aece-d21599093db5");

                // Marin inapte
                infos.put("source", "https://run.mocky.io/v3/971a4c10-63b3-4ab6-bd58-aaab66ab4365");
                infos.put("field", "decisionMedicale");
                infos.put("nestedField", "libelle");
                return infos;
            case("amfore"):
//                return "amfore.json";
        }
        return null;
    }
}
