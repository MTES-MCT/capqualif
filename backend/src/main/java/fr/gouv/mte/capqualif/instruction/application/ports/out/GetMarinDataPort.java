package fr.gouv.mte.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.legislateur.mock.DataToExtractFromExistingDataSource;
import fr.gouv.mte.capqualif.titre.domain.Value;

import java.util.List;

public interface GetMarinDataPort {
    List<Entry> getMarinData(String numeroDeMarin, List<DataToExtractFromExistingDataSource> dataToExtractFromExistingDataSource);
}
