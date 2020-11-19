package fr.gouv.mte.capqualif.title.application.services;

import fr.gouv.mte.capqualif.title.application.ports.in.GetTitleUseCase;
import fr.gouv.mte.capqualif.title.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitleService implements GetTitleUseCase {

    @Autowired
    GetTitlePort getTitlePort;

    @Override
    public Title getTitle(String titleId) {
        return getTitlePort.getTitle(titleId);
    }
}
