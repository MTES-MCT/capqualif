package fr.gouv.mte.capqualif.sailor.application.ports.out;

import fr.gouv.mte.capqualif.sailor.domain.Sailor;

public interface GetSailorBasicDataPort {

    Sailor getSailorBasicData(String sailorNumber);

}
