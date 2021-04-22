package fr.gouv.mte.capqualif.capQualif.demande.application.ports.out;

import fr.gouv.mte.capqualif.capQualif.demande.domain.marin.Marin;

public interface GetMarinDataPort {

    Marin getMarin(String numeroDeMarin);

}
