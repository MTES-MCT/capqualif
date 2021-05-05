package fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.in;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.Titre;

public interface GetTitreUseCase {

    Titre getTitre(String titreId);

}
