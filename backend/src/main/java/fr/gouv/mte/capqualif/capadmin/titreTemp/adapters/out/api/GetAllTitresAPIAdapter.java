package fr.gouv.mte.capqualif.capadmin.titreTemp.adapters.out.api;

import fr.gouv.mte.capqualif.capadmin.titreTemp.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.out.GetAllTitresPort;
import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;
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
