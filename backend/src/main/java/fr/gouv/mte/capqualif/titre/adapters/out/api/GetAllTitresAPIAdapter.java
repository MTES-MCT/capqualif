package fr.gouv.mte.capqualif.titre.adapters.out.api;

import fr.gouv.mte.capqualif.titre.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetAllTitresPort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitresAPIAdapter implements GetAllTitresPort {

    @Autowired
    TitresApiMock titresApiMock;

    @Override
    public List<Titre> getAllTitres() {
        return titresApiMock.findAll();
    }
}