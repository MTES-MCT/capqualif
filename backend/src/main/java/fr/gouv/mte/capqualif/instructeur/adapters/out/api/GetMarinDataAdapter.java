package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.JsonArray;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetAptitudeMedicalePort;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JsonArray getMarinData(String existingDataSource, String numeroDeMarin) {

        // TO DO : convert numeroDeMarin to ID_ADMINISTRE => api pda

        String request = existingDataSource + numeroDeMarin;
        System.out.println("Looking for " + request);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(request, String.class);
        System.out.println(responseEntity);
        return null;
    }

}
