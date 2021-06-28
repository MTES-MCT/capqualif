package fr.gouv.mte.capqualif.shared;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.MarinDTO;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.TitreOfMarinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class JsonGetter {

    @Autowired
    private RestTemplate restTemplate;

    String ENVIRONMENT = System.getenv("ENV_TYPE");

    public APIDataDTO getDtoFromAPI(String marinId, String apiUrl, APINames dtoClassName) {
        System.out.println(dtoClassName);
        String className = "fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto." + dtoClassName.getName() + "DTO";
        String res = getJson(marinId, apiUrl);

        Gson gson = new Gson();

        Class<?> myClass = null;

        try {
            myClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        if (res.startsWith("[")) {
////            Type listType = new TypeToken<List<myClass>>(){}.getType();
////            return gson.fromJson(res, listType);
////            (APIDataDTO) gson.fromJson(res, myClass);
//        }

        APIDataDTO apiDataDTO = (APIDataDTO) gson.fromJson(res, myClass);
        apiDataDTO.setName(dtoClassName);
        return apiDataDTO;
//        return (APIDataDTO) gson.fromJson(res, myClass);
    }

    public MarinDTO getMarinDtoFromAPI(String marinId, String apiUrl) {
        String res = getJson(marinId, apiUrl);
        Gson gson = new Gson();
        return gson.fromJson(res, MarinDTO.class);
    }

    public List<TitreOfMarinDto> getTitresOfMarinDtoFromAPI(String marinId, String apiUrl) {
        // https://github.com/google/gson/blob/master/UserGuide.md#collections-examples
        String res = getJson(marinId, apiUrl);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<TitreOfMarinDto>>(){}.getType();
        return gson.fromJson(res, listType);
    }

    public String getJson(String marinId, String url) {
        String request = ENVIRONMENT.equals("local") ? url :  url + "/" + marinId;
        return restTemplate.getForObject(request, String.class);
    }

}
