package fr.gouv.mte.capqualif.titre.application.services;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetTitreUseCase;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitreService implements GetTitreUseCase {

    @Autowired
    GetTitrePort getTitrePort;

    @Override
    public Titre getTitre(String titreId) {
        return getTitrePort.getTitre(titreId);
    }
}
