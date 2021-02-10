package fr.gouv.mte.capqualif.titre.adapters.out.api;

import fr.gouv.mte.capqualif.titre.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitreApiAdapter implements GetTitrePort {
    @Autowired
    TitresApiMock titresApiMock;

    @Override
    public Titre getTitre(String titreId) {
        return titresApiMock.findTitreById(titreId);
    }
}
