package fr.gouv.mte.capqualif.capqualif.request.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;

public interface GetMarinDataPort {

    Marin getMarin(String numeroDeMarin);

}
