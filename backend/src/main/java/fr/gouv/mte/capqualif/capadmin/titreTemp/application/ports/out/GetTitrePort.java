package fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.out;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.Titre;

public interface GetTitrePort {

    Titre findTitreById(String titreId);

}
