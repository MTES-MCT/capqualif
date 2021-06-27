package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSource;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    String ENVIRONMENT = System.getenv("ENV_TYPE");

    public Map<APINames, String> getAllMarinData(String marinId, DataSources dataSources) {
        Map<APINames, String> marinData = new HashMap<>();
        for (DataSource dataSource : dataSources.getDataSources()) {
             marinData.put(dataSource.getAPIName(), getJson(marinId, dataSource.getAPIUrl()));
        }
        return marinData;
    }

    private String getJson(String marinId, String url) {
        String request = ENVIRONMENT.equals("local") ? url :  url + "/" + marinId;
        System.out.println("Looking for " + request);
        String res = restTemplate.getForObject(request, String.class);
        Gson gson = new Gson();
        String json = gson.fromJson(res, JsonElement.class).toString();
        System.out.println("Retrieved json is " + json);
        return json;
    }
}
