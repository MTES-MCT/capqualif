package fr.gouv.mte.capqualif.domain.capQualif.demande.application.ports.out;

import fr.gouv.mte.capqualif.domain.capQualif.demande.domain.marin.Marin;

public interface GetMarinDataPort {

    Marin getMarin(String numeroDeMarin);

}
