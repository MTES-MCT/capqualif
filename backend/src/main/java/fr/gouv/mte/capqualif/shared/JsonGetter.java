package fr.gouv.mte.capqualif.shared;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.marinDashboard.domain.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JsonGetter {

    @Autowired
    private RestTemplate restTemplate;

    public JsonElement getJsonFromAPI(String numeroDeMarin, String apiUrl) {

        // TO DO : convert numeroDeMarin to ID_ADMINISTRE

//        String request = apiUrl + numeroDeMarin;
//        System.out.println("Looking for " + request);

//        For MOCKY :
        String request = apiUrl;
        System.out.println("Looking for " + request);

        String res = restTemplate.getForObject(request, String.class);
        Gson gson = new Gson();
        return gson.fromJson(res, JsonElement.class);
    }

    public Marin getMarinFromAPI(String numeroDeMarin, String apiUrl) {
//        String request = apiUrl + numeroDeMarin;
//        System.out.println("Looking for " + request);

        String request = apiUrl;
        System.out.println("Looking for " + request);

        String res = restTemplate.getForObject(request, String.class);
        Gson gson = new Gson();
        return gson.fromJson(res, Marin.class);
    }

}
