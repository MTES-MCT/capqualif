package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ExtractionResult;
import java.util.List;
import java.util.Map;

public interface GetMarinDataPort {

    Map<APINames, String> getAllMarinData(String marinId, DataSources dataSources);

}
