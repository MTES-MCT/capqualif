package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JsonElement getMarinData(String existingDataSource, String numeroDeMarin) {

        // TO DO : convert numeroDeMarin to ID_ADMINISTRE

//        String request = existingDataSource + numeroDeMarin;
//        System.out.println("Looking for " + request);

        String request = existingDataSource;
        System.out.println("Looking for " + request);

        String res = restTemplate.getForObject(request, String.class);

        Gson gson = new Gson();
        JsonElement json = gson.fromJson(res, JsonElement.class);

        return json;
    }

}
