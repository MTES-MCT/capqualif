package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSource;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.MarinData;
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

    public Map<APINames, MarinData> getAllMarinData(String marinId, DataSources dataSources) {
        Map<APINames, APIDataDTO> rawMarinData = new HashMap<>();
        for (DataSource dataSource : dataSources.getDataSources()) {
            rawMarinData.put(dataSource.getAPIName(),
                    jsonGetter.getDtoFromAPI(marinId, dataSource.getAPIUrl(),  dataSource.getAPIName().getName()));
        }
        Map<APINames, MarinData> marinData = new HashMap<>();
        for (Map.Entry<APINames, APIDataDTO> entry : rawMarinData.entrySet()) {
            marinData.put(entry.getKey(), instructionMapper.mapToDomaineEntity((EsculapeDTO) entry.getValue()));
        }
        return marinData;
    }
}
