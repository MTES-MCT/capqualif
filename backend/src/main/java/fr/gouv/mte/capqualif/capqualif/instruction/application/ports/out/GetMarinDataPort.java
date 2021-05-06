package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.capadmin.adapters.out.mock.CorrespondingDataInExistingDataSource;

import java.util.List;

public interface GetMarinDataPort {
    List<ExtractionResult> getMarinData(String numeroDeMarin, CorrespondingDataInExistingDataSource correspondingDataInExistingDataSource);
}
