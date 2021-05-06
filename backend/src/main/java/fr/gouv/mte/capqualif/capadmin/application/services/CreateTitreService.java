package fr.gouv.mte.capqualif.capadmin.application.services;

import fr.gouv.mte.capqualif.capadmin.application.ports.in.CreateTitreUseCase;
import fr.gouv.mte.capqualif.capadmin.application.ports.out.CreateTitrePort;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTitreService implements CreateTitreUseCase {

    @Autowired
    CreateTitrePort createTitrePort;

    public CreateTitreService(CreateTitrePort createTitrePort) {
        this.createTitrePort = createTitrePort;
    }

    @Override
    public Titre createTitre(Titre titre) {
        return createTitrePort.createTitre(titre);
    }
}
