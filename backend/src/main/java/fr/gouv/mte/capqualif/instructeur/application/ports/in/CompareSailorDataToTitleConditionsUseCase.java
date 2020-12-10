package fr.gouv.mte.capqualif.instructeur.application.ports.in;

import fr.gouv.mte.capqualif.instructeur.domain.CompareResult;

import java.io.IOException;
import java.util.List;

public interface CompareSailorDataToTitleConditionsUseCase {
    List<CompareResult> compareSailorDataToTitleConditions(String sailorNumber, String titleId) throws IOException;
}