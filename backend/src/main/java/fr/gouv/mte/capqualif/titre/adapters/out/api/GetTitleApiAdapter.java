package fr.gouv.mte.capqualif.titre.adapters.out.api;

import fr.gouv.mte.capqualif.titre.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitleApiAdapter implements GetTitlePort {
    @Autowired
    TitresApiMock titresApiMock;

    @Override
    public Titre getTitle(String titleId) {
        return titresApiMock.findTitleById(titleId);
    }
}
