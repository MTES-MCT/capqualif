package fr.gouv.mte.capqualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.instruction.domain.ComparisonResultFinal;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonResultFinal> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}