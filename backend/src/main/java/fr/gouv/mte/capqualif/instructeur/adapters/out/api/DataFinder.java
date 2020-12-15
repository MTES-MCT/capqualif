package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetAptitudeMedicalePort;
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
    GetAptitudeMedicalePort getAptitudeMedicalePort;

//    public List<String> findMatchingMarinData(String existingDataSource, String sailorNumber) {
//        List<String> data = getData(existingDataSource, sailorNumber);
//        return data;
//    }

    public List<String> findMatchingMarinData(String existingDataSource, String sailorNumber) {

        Map infos = whatInfosToLookFor(existingDataSource);

        JsonArray json = getAptitudeMedicalePort.getAptitudeMedicale(infos.get("source").toString(), sailorNumber);
//                localJsonGetter.getJson(infos.get("source").toString());

        ArrayList allMatchingData = new ArrayList();

        if (json != null) {
            for (JsonElement element : json) {
                JsonObject jsonObject = element.getAsJsonObject();
                String data;
                if (!infos.containsKey("subField")) {
                    data = jsonObject.get(infos.get("field").toString()).getAsString();
                }
                JsonObject field = jsonObject.get(infos.get("field").toString()).getAsJsonObject();
                data = field.get(infos.get("subField").toString()).getAsString();
                allMatchingData.add(data);
            }
        }

        return allMatchingData;
    }

    private Map whatInfosToLookFor(String existingDataSource) {
        HashMap<String, String> infos = new HashMap<>();
        switch(existingDataSource) {
            case("esculape"):
//                infos.put("source", "mocks/aptitudeMedicale.json");
                infos.put("source", "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/");
//                infos.put("source", "https://jsonplaceholder.typicode.com/todos/1");
                infos.put("field", "decisionMedicale");
                infos.put("subField", "libelle");
                return infos;
            case("amfore"):
//                return "amfore.json";
        }
        return null;
    }


}
