package fr.gouv.mte.capqualif.capadmin.titreTemp.adapters.out.api;

import fr.gouv.mte.capqualif.capadmin.titreTemp.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitreApiAdapter implements GetTitrePort {
    @Autowired
    TitresApiMock titresApiMock;

    @Override
    public Titre findTitreById(String titreId) {
        return titresApiMock.findTitreById(titreId);
    }
}
