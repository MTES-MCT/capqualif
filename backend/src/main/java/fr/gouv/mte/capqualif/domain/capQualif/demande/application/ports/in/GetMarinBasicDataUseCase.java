package fr.gouv.mte.capqualif.domain.capQualif.demande.application.ports.in;

import fr.gouv.mte.capqualif.domain.capQualif.demande.domain.marin.Marin;

public interface GetMarinBasicDataUseCase {

    Marin getMarinBasicData(String id);

}
