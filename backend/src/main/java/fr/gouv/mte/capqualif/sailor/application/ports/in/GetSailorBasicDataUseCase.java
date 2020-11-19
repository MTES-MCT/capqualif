package fr.gouv.mte.capqualif.sailor.application.ports.in;

import fr.gouv.mte.capqualif.sailor.domain.Sailor;

public interface GetSailorBasicDataUseCase {

    Sailor getSailorBasicData(String id);

}
