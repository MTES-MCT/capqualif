package fr.gouv.mte.capqualif.marin.application.ports.in;

import fr.gouv.mte.capqualif.marin.domain.marin.Marin;

public interface GetMarinBasicDataUseCase {

    Marin getMarinBasicData(String id);

}
