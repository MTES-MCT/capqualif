package fr.gouv.mte.capqualif.capQualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.capQualif.instruction.domain.ComparisonsSummary;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonsSummary> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}