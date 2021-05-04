package fr.gouv.mte.capqualif.shared;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api.dto.MarinDto;
import fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api.dto.TitreOfMarinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class JsonGetter {

    @Autowired
    private RestTemplate restTemplate;

    public JsonElement getJsonFromAPI(String numeroDeMarin, String apiUrl) {
        String res = getJson(numeroDeMarin, apiUrl);
        Gson gson = new Gson();
        return gson.fromJson(res, JsonElement.class);
    }

    public MarinDto getMarinDtoFromAPI(String numeroDeMarin, String apiUrl) {
        String res = getJson(numeroDeMarin, apiUrl);
        Gson gson = new Gson();
        return gson.fromJson(res, MarinDto.class);
    }

    public List<TitreOfMarinDto> getTitresOfMarinDtoFromAPI(String numeroDeMarin, String apiUrl) {
        // https://github.com/google/gson/blob/master/UserGuide.md#collections-examples
        String res = getJson(numeroDeMarin, apiUrl);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<TitreOfMarinDto>>(){}.getType();
        List<TitreOfMarinDto> titres = gson.fromJson(res, listType);
        return titres;
    }

    private String getJson(String numeroDeMarin, String apiUrl) {
//      String request = apiUrl + numeroDeMarin;
        String request = apiUrl;
        System.out.println("Looking for " + request);
        return restTemplate.getForObject(request, String.class);
    }

}
