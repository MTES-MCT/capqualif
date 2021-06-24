package fr.gouv.mte.capqualif.capadmin.application.ports.in;

import fr.gouv.mte.capqualif.capadmin.domain.Titre;

public interface CreateTitreUseCase {
    Titre createTitre(Titre titre);
}
