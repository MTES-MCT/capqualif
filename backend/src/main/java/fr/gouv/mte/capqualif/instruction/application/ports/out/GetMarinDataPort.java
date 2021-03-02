package fr.gouv.mte.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.DataToExtractFromExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.EntryInExistingDataSource;

import java.util.List;

public interface GetMarinDataPort {
    List<ExtractionResult> getMarinData(String numeroDeMarin, DataToExtractFromExistingDataSource dataToExtractFromExistingDataSource);
}
