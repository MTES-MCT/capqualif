package fr.gouv.mte.capqualif.title.adapters.out.api;

import fr.gouv.mte.capqualif.title.adapters.out.api.mocks.TitlesApiMock;
import fr.gouv.mte.capqualif.title.application.ports.out.GetAllTitlesPort;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitlesAPIAdapter implements GetAllTitlesPort {

    @Autowired
    TitlesApiMock titlesApiMock;

    @Override
    public List<Title> getAllTitles() {
        return titlesApiMock.findAll();
    }
}
