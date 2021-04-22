package fr.gouv.mte.capqualif.domain.capQualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.domain.capQualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.domain.capAdmin.mock.CorrespondingDataInExistingDataSource;

import java.util.List;

public interface GetMarinDataPort {
    List<ExtractionResult> getMarinData(String numeroDeMarin, CorrespondingDataInExistingDataSource correspondingDataInExistingDataSource);
}
