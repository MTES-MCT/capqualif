package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.*;
import fr.gouv.mte.capqualif.shared.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetMarinDataAdapter implements GetMarinDataPort {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    JsonGetter jsonGetter;

    @Autowired
    InstructionMapper instructionMapper;

    String ENVIRONMENT = System.getenv("ENV_TYPE");

    public Map<String, MarinData> getAllMarinData(String marinId, DataSources dataSources) {
        Map<String, APIDataDTO> marinDataDTOs = new HashMap<>();
        for (DataSource dataSource : dataSources.getDataSources()) {
            marinDataDTOs.put(dataSource.getJuridicalDesignation().getName(),
                    jsonGetter.getDtoFromAPI(marinId, dataSource.getAPIUrl(),  dataSource.getAPIName().getName()));
        }
        Map<String, MarinData> marinData = new HashMap<>();
        for (Map.Entry<String, APIDataDTO> entry : marinDataDTOs.entrySet()) {
            marinData.put(entry.getKey(), instructionMapper.mapToDomainEntity((EsculapeDTO) entry.getValue()));
        }
        return marinData;
    }
}
