package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import fr.gouv.mte.capqualif.marin.domain.Sailor;

public interface GetSailorPort {

    Sailor getSailor(String sailorNumber);

}
