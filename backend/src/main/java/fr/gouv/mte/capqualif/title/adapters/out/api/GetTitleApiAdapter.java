package fr.gouv.mte.capqualif.title.adapters.out.api;

import fr.gouv.mte.capqualif.title.adapters.out.api.mocks.TitlesApiMock;
import fr.gouv.mte.capqualif.title.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitleApiAdapter implements GetTitlePort {
    @Autowired
    TitlesApiMock titlesApiMock;

    @Override
    public Title getTitle(String titleId) {
        return titlesApiMock.findTitleById(titleId);
    }
}
