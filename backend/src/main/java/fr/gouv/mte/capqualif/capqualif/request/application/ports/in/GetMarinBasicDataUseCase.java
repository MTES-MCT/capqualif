package fr.gouv.mte.capqualif.capqualif.request.application.ports.in;

import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;

public interface GetMarinBasicDataUseCase {

    Marin getMarinBasicData(String id);

}
