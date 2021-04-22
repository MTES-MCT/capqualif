package fr.gouv.mte.capqualif.capQualif.demande.application.ports.in;

import fr.gouv.mte.capqualif.capQualif.demande.domain.marin.Marin;

public interface GetMarinBasicDataUseCase {

    Marin getMarinBasicData(String id);

}
