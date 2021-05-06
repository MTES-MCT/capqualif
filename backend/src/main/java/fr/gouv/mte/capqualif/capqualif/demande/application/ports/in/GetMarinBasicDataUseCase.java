package fr.gouv.mte.capqualif.capqualif.demande.application.ports.in;

import fr.gouv.mte.capqualif.capqualif.demande.domain.marin.Marin;

public interface GetMarinBasicDataUseCase {

    Marin getMarinBasicData(String id);

}
