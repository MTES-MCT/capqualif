package fr.gouv.mte.capqualif.instructeur.adapters.out.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingAPIMapper;
import fr.gouv.mte.capqualif.shared.JsonExtractor;
import fr.gouv.mte.capqualif.titre.domain.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JsonExtractor jsonExtractor;


    @Override
    public List<Map<String, String>> getMarinData(String numeroDeMarin, Value mainValue, ExistingAPIMapper existingAPIMapper) {
        JsonElement marinJson = getJson(numeroDeMarin, existingAPIMapper.getAPIUrl());
        return jsonExtractor.getWantedData(marinJson, mainValue, existingAPIMapper);
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
}
