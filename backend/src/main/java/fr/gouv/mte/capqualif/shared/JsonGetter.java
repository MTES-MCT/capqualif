package fr.gouv.mte.capqualif.shared;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.TitreOfMarinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class JsonGetter {

    @Autowired
    private RestTemplate restTemplate;

    String ENVIRONMENT = System.getenv("ENV_TYPE");

    public JsonElement getJsonFromAPI(String marinId, String apiUrl, String name) {
        String res = getJson(marinId, apiUrl);
        Gson gson = new Gson();
        Class<?> myClass = null;
        try {
            myClass = Class.forName("java.lang.Object.com.google.gson.JsonElement");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gson.fromJson(res, (Type) myClass);

//        return gson.fromJson(res, JsonElement.class);
    }

    public APIDataDTO getDtoFromAPI(String marinId, String apiUrl, String dtoClassName) {
        System.out.println(dtoClassName);
        String className = "fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto." + dtoClassName + "DTO";
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

        return (APIDataDTO) gson.fromJson(res, myClass);
    }

//    public MarinDto getMarinDtoFromAPI(String marinId, String apiUrl) {
//        String res = getJson(marinId, apiUrl);
//        Gson gson = new Gson();
//        return gson.fromJson(res, MarinDto.class);
//    }

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
//        Gson gson = new Gson();
//        return gson.fromJson(res, JsonElement.class).toString();
    }

//    private String getJson(String numeroDeMarin, String apiUrl) {
////      String request = apiUrl + numeroDeMarin;
//        String request = apiUrl;
//        System.out.println("Looking for " + request);
//        return restTemplate.getForObject(request, String.class);
//    }

}
