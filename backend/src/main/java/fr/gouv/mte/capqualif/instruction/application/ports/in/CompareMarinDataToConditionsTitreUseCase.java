package fr.gouv.mte.capqualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.instruction.domain.ComparisonResultsSummary;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonResultsSummary> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}