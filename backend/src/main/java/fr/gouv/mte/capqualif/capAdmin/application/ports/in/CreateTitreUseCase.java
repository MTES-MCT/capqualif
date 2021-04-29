package fr.gouv.mte.capqualif.capAdmin.application.ports.in;

import fr.gouv.mte.capqualif.capAdmin.domain.Titre;

public interface CreateTitreUseCase {

    Titre createTitre(Titre titre);

}
