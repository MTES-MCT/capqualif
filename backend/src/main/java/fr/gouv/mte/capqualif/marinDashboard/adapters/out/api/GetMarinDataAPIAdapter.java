package fr.gouv.mte.capqualif.marinDashboard.adapters.out.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.marinDashboard.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.marinDashboard.domain.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetMarinDataAPIAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    String API_URL = "***REMOVED******REMOVED***";
    String API_URL_MOCK = "***REMOVED***";

    @Override
    public Marin getMarinData(String numeroDeMarin) {
        Marin marinJson = getMarin(numeroDeMarin, API_URL_MOCK);
        return marinJson;
    }

    private Marin getMarin(String numeroDeMarin, String existingDataSource) {
        String request = existingDataSource;
        System.out.println("Looking for " + request);

        String res = restTemplate.getForObject(request, String.class);
        Gson gson = new Gson();
        Marin marinJson = gson.fromJson(res, Marin.class);
        return marinJson;
    }

    private JsonElement getJson(String numeroDeMarin, String existingDataSource) {

        // TO DO : convert numeroDeMarin to ID_ADMINISTRE

//        String request = existingDataSource + numeroDeMarin;
//        System.out.println("Looking for " + request);

//        For MOCKY :
        String request = existingDataSource;
        System.out.println("Looking for " + request);

        String res = restTemplate.getForObject(request, String.class);
        Gson gson = new Gson();
        JsonElement json = gson.fromJson(res, JsonElement.class);
        return json;
    }


//    @Autowired
//    private MarinCivilDataApiMock marinCivilDataApiMock;
//
//    @Autowired
//    private MarinEducationDataApiMock marinEducationDataApiMock;
//
//    @Autowired
//    private MarinIdentityMarkersDataApiMock marinIdentityMarkersDataApiMock;
//
//
//    @Override
//    public Marin getMarinData(String numeroDeMarin) {
//        getMarinCivilData(numeroDeMarin);
//        getMarinEducationData(numeroDeMarin);
//        Marin marin = new Marin(
//                numeroDeMarin,
//                getMarinCivilData(numeroDeMarin),
//                getMarinIdentityMarkersData(numeroDeMarin),
//                getMarinEducationData(numeroDeMarin)
//        );
//        return marin;
//    }
//
//    private MarinCivilData getMarinCivilData(String numeroDeMarin) {
//        // TO DO : replace by an API call : [URL_BASE_ADM]/api/v1/marins?numIdentification= {numIdentification}
//        return marinCivilDataApiMock.findMarinCivilDataByNumeroDeMarin(numeroDeMarin);
//    }
//
//    private MarinEducationData getMarinEducationData(String numeroDeMarin) {
//        // TO DO : replace by an API call : [URL_BASE_ITEM]/api/v1/titres/{idAdmIntervenant}
//        return marinEducationDataApiMock.findMarinEducationDataByNumeroDeMarin(numeroDeMarin);
//    }
//
//    private MarinIdentityMarkersData getMarinIdentityMarkersData(String numeroDeMarin) {
//        // TO DO : replace by an API call : [URL_BASE_ITEM]/api/v1/titres/{idAdmIntervenant}
//        return marinIdentityMarkersDataApiMock.findMarinIdentityMarkersByNumeroDeMarin(numeroDeMarin);
//    }

}
