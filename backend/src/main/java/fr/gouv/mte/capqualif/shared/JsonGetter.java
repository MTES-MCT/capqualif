package fr.gouv.mte.capqualif.shared;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.AmforeDto;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.ApiDataDto;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.ItemDto;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.MarinDTO;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.TitreOfMarinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Component
public class JsonGetter {

    @Autowired
    private RestTemplate restTemplate;

    String ENVIRONMENT = System.getenv("ENV_TYPE");
    String DTO_PACKAGE = "fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto";

    public List<ApiDataDto> getDtoFromApi(String marinId, String apiUrl, APINames dtoClassName) {
        String res = getJson(marinId, apiUrl);
        Gson gson = new Gson();
        String className = DTO_PACKAGE + "." + dtoClassName.getName() + "Dto";
        Class<?> myClass = createClass(className);
        if (isJsonArray(res)) {
            return getApiDataDtos(dtoClassName, res, gson);
        } else {
            ApiDataDto apiDataDTO = (ApiDataDto) gson.fromJson(res, myClass);
            /*
                We are wrapping each single ApiDataDto object in its own List to homogenize returned value. It is unwrapped later in the code.
             */
            return Collections.singletonList(addApiName(dtoClassName, apiDataDTO));
        }
    }

    private boolean isJsonArray(String res) {
        return res.startsWith("[");
    }

    /**
     * TODO: refactor to a more elegant solution.
     */
    private List<ApiDataDto> getApiDataDtos(APINames dtoClassName, String res, Gson gson) {
        switch (dtoClassName) {
            case AMFORE:
                Type amforeListType = new TypeToken<List<AmforeDto>>(){}.getType();
                List<ApiDataDto> amfores = gson.fromJson(res, amforeListType);
                for(ApiDataDto amforeDto : amfores) {
                    addApiName(dtoClassName, amforeDto);
                }
                return amfores;
            case ITEM:
                Type itemListType = new TypeToken<List<ItemDto>>(){}.getType();
                List<ApiDataDto> items = gson.fromJson(res, itemListType);
                for(ApiDataDto item : items) {
                    addApiName(dtoClassName, item);
                }
                return items;
            default:
                return null;
        }
    }

    private ApiDataDto addApiName(APINames dtoClassName, ApiDataDto apiDataDTO) {
        apiDataDTO.setName(dtoClassName);
        return apiDataDTO;
    }

    private Class<?> createClass(String className) {
        Class<?> myClass = null;

        try {
            myClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return myClass;
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
