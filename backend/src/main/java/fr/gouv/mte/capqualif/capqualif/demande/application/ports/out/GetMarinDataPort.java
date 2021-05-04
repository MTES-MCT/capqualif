package fr.gouv.mte.capqualif.capqualif.demande.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.demande.domain.marin.Marin;

public interface GetMarinDataPort {

    Marin getMarin(String numeroDeMarin);

}
