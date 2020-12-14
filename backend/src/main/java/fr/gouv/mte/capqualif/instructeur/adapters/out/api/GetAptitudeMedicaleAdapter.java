package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.JsonArray;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetAptitudeMedicalePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GetAptitudeMedicaleAdapter implements GetAptitudeMedicalePort {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JsonArray getAptitudeMedicale(String source, String sailorNumber) {

        String request = source + sailorNumber;
        System.out.println("Looking for " + request);


        ResponseEntity<String> responseEntity = restTemplate.getForEntity(request, String.class);
        System.out.println(responseEntity);


        return null;
    }

}
