package fr.gouv.mte.capqualif.marin.application.ports.in;

import fr.gouv.mte.capqualif.marin.domain.Sailor;

public interface GetMarinDataUseCase {

    Sailor getMarinData(String id);

}
