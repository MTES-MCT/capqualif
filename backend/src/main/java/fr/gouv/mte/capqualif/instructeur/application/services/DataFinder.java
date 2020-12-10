package fr.gouv.mte.capqualif.instructeur.application.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.utils.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataFinder {

    @Autowired
    JsonReader jsonReader;

    public List<String> findMatchingMarinData(String existingDataSource, String sailorNumber) {
        List<String> data = getData(existingDataSource);
        return data;
    }

    private List<String> getData(String existingDataSource) {

        Map infos = whatInfosToLookFor(existingDataSource);

        JsonArray json = jsonReader.readJson(infos.get("source").toString());

        ArrayList allMatchingData = new ArrayList();

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

        return allMatchingData;
    }

    private Map whatInfosToLookFor(String existingDataSource) {
        HashMap<String, String> infos = new HashMap<>();
        switch(existingDataSource) {
            case("esculape"):
                infos.put("source", "aptitudeMedicale.json");
                infos.put("field", "decisionMedicale");
                infos.put("subField", "libelle");
                return infos;
            case("amfore"):
//                return "amfore.json";
        }
        return null;
    }




}


//        System.out.println(aptitudeMedicaleJson);

//        JsonObject convertedObject = new Gson().fromJson(aptitudeMedicaleJson, JsonObject.class);


//        String fileName = "aptitudeMedicale.json";


//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream(fileName);
//
//
//        File json = new File(classLoader.getResource(fileName).getFile());
//
//
//        //File is found
//        System.out.println("File Found : " + json);


//            switch (existingDataSource) {
//                case "esculape":
//                    // 'http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/idMarin'
//
//
//                    break;
//                case "amfore":
//                    // http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/idMarin
//            }
        // return donnee
