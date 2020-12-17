package fr.gouv.mte.capqualif.marin.application.ports.out;

import fr.gouv.mte.capqualif.marin.domain.Sailor;

public interface GetSailorDataPort {

    Sailor getSailorData(String sailorNumber);

}
