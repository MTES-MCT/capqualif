package fr.gouv.mte.capqualif.capAdmin.application.ports.out;

import fr.gouv.mte.capqualif.capAdmin.domain.Titre;

public interface CreateTitrePort {

    Titre createTitre(Titre titre);

}
