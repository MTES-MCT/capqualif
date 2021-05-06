package fr.gouv.mte.capqualif.capQualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.capQualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.mock.CorrespondingDataInExistingDataSource;

import java.util.List;

public interface GetMarinDataPort {
    List<ExtractionResult> getMarinData(String numeroDeMarin, CorrespondingDataInExistingDataSource correspondingDataInExistingDataSource);
}
