package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ComparisonsSummary;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonsSummary> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}