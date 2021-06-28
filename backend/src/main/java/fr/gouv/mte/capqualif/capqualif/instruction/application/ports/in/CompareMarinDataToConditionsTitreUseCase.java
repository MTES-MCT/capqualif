package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ComparisonsSummary;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    void compareMarinDataToConditionsTitre(String marinId);
}