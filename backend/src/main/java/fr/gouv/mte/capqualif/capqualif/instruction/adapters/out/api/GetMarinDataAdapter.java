package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.*;
import fr.gouv.mte.capqualif.shared.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    JsonGetter jsonGetter;

    @Autowired
    InstructionMapper instructionMapper;

    String ENVIRONMENT = System.getenv("ENV_TYPE");

    @Autowired
    private RestTemplate restTemplate;

    DataSources DATA_SOURCES_MOCK = new DataSources(Arrays.asList(
            new DataSource(JuridicalDesignations.AGE, APINames.ADMINISTRES, System.getenv("ADMINISTRES_API_URL")),
            new DataSource(JuridicalDesignations.APTITUDE_MEDICALE, APINames.ESCULAPE, System.getenv("ESCULAPE_API_URL"))
//            new DataSource(JuridicalDesignations.FORMATIONS, APINames.AMFORE, System.getenv("AMFORE_API_URL"))
//            new DataSource(JuridicalDesignations.TITRES, APINames.ITEM, System.getenv("ITEM_API_URL"))
    ));

    public Map<String, MarinData> getAllMarinData(String marinId) {
        Map<String, APIDataDTO> marinDataDTOs = new HashMap<>();
        for (DataSource dataSource : DATA_SOURCES_MOCK.getDataSources()) {
            marinDataDTOs.put(dataSource.getJuridicalDesignation().getName(),
                    jsonGetter.getDtoFromAPI(marinId, dataSource.getAPIUrl(), dataSource.getAPIName()));
        }
        Map<String, MarinData> marinData = new HashMap<>();
        for (Map.Entry<String, APIDataDTO> entry : marinDataDTOs.entrySet()) {
            marinData.put(entry.getKey(), instructionMapper.mapToDomainEntity(entry.getValue()));
        }
        return marinData;
    }
}
