package fr.gouv.mte.capqualif.capAdmin.titre.application.ports.in;

import fr.gouv.mte.capqualif.capAdmin.titre.domain.Titre;

public interface GetTitreUseCase {

    Titre getTitre(String titreId);

}
