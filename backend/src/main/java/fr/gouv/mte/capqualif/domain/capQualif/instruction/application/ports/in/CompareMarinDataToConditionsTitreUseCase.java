package fr.gouv.mte.capqualif.domain.capQualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.domain.capQualif.instruction.domain.ComparisonsSummary;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonsSummary> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}