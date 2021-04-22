package fr.gouv.mte.capqualif.domain.capAdmin.titre.application.ports.out;

import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.Titre;

public interface GetTitrePort {

    Titre findTitreById(String titreId);

}
