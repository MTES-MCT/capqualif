package fr.gouv.mte.capqualif.marin.application.ports.out;

import fr.gouv.mte.capqualif.marin.domain.marin.Marin;

public interface GetMarinDataPort {

    Marin getMarin(String numeroDeMarin);

}
