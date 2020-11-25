package fr.gouv.mte.capqualif.comparateur.application.ports.in;

import fr.gouv.mte.capqualif.comparateur.domain.CompareResult;
import fr.gouv.mte.capqualif.sailor.domain.Sailor;
import fr.gouv.mte.capqualif.title.domain.Title;

public interface CompareSailorDataToTitleConditionsUseCase {
    CompareResult compareSailorDataToTitleConditions(String sailorNumber, String titleId);
}