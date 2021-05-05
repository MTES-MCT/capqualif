package fr.gouv.mte.capqualif.capAdmin.titreTemp.application.services;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.in.GetTitreUseCase;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitreService implements GetTitreUseCase {

    @Autowired
    GetTitrePort getTitrePort;

    @Override
    public Titre getTitre(String titreId) {
        return getTitrePort.findTitreById(titreId);
    }
}
