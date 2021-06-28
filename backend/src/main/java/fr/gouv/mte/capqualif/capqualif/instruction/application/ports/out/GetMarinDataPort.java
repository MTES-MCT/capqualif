package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.MarinData;

import java.util.Map;

public interface GetMarinDataPort {

    Map<String, MarinData> getAllMarinData(String marinId, DataSources dataSources);

}
