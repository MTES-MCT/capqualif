package fr.gouv.mte.capqualif.instruction.application.ports.in;

import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}