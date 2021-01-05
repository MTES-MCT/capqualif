package fr.gouv.mte.capqualif.instructeur.application.ports.in;

import fr.gouv.mte.capqualif.instructeur.domain.ComparisonResult;

import java.util.List;

public interface CompareMarinDataToConditionsTitreUseCase {
    List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin);
}