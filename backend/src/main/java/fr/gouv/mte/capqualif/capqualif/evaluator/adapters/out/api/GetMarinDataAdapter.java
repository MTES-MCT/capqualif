//package fr.gouv.mte.capqualif.capqualif.evaluator.adapters.out.api;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import fr.gouv.mte.capqualif.capadmin.adapters.out.mock.CorrespondingDataInExistingDataSource;
//import fr.gouv.mte.capqualif.capqualif.evaluator.application.ports.out.GetMarinDataPort;
//import fr.gouv.mte.capqualif.capqualif.evaluator.domain.archive.ExtractionResult;
//import fr.gouv.mte.capqualif.shared.JsonExtractor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Component
//public class GetMarinDataAdapter implements GetMarinDataPort {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private JsonExtractor jsonExtractor;
//
//    @Override
//    public List<ExtractionResult> getMarinData(String numeroDeMarin, CorrespondingDataInExistingDataSource correspondingDataInExistingDataSource) {
//        String marinJson = getJson(numeroDeMarin, correspondingDataInExistingDataSource.getAPIUrl());
//        return jsonExtractor.getAllWantedData(marinJson, correspondingDataInExistingDataSource);
//    }
//
//
//    private String getJson(String numeroDeMarin, String existingDataSource) {
//
//        // TO DO : convert numeroDeMarin to ID_ADMINISTRE
//
////        String request = existingDataSource + numeroDeMarin;
////        System.out.println("Looking for " + request);
//
////        For MOCKY :
//        String request = existingDataSource;
//        System.out.println("Looking for " + request);
//
//        String res = restTemplate.getForObject(request, String.class);
//        Gson gson = new Gson();
//        String json = gson.fromJson(res, JsonElement.class).toString();
//        System.out.println("Retrieved json is " + json);
//        return json;
//    }
//}
