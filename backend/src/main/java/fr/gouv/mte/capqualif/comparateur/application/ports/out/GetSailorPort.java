package fr.gouv.mte.capqualif.comparateur.application.ports.out;

import fr.gouv.mte.capqualif.sailor.domain.Sailor;

public interface GetSailorPort {

    Sailor getSailor(String sailorNumber);

}
