package fr.gouv.mte.capqualif.titre.application.ports.out;

import fr.gouv.mte.capqualif.titre.domain.Titre;

public interface GetTitrePort {

    Titre findTitreById(String titreId);

}
