package fr.gouv.mte.capqualif.instructeur.application.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataFinder {

    public JsonObject findMatchingMarinData(String existingDataSource, String sailorNumber) {

        // TO DO : convert sailorNumber to idMarin when API is available

        String fileName = "aptitudeMedicale.json";
        ClassLoader classLoader = getClass().getClassLoader();

        File json = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + json);

//        Gson gson = new Gson();
//
//        JsonObject body = gson.fromJson(String.valueOf(json), JsonObject.class);

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
        return null;
    }
}
