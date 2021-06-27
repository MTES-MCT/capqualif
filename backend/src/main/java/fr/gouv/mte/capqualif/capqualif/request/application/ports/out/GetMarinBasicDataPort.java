package fr.gouv.mte.capqualif.capqualif.request.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;

public interface GetMarinBasicDataPort {

    Marin getMarin(String numeroDeMarin);

}
