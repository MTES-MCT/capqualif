package fr.gouv.mte.capqualif.titre.adapters.out.api;

import fr.gouv.mte.capqualif.titre.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetAllTitlesPort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitlesAPIAdapter implements GetAllTitlesPort {

    @Autowired
    TitresApiMock titresApiMock;

    @Override
    public List<Titre> getAllTitles() {
        return titresApiMock.findAll();
    }
}
