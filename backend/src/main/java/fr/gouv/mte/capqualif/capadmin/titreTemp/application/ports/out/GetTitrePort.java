package fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.out;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;

public interface GetTitrePort {

    Titre findTitreById(String titreId);

}
