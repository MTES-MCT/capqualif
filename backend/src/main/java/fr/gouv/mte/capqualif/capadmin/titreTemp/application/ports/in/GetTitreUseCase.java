package fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.in;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;

public interface GetTitreUseCase {

    Titre getTitre(String titreId);

}
