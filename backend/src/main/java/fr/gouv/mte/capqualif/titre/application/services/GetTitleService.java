package fr.gouv.mte.capqualif.titre.application.services;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetTitleUseCase;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTitleService implements GetTitleUseCase {

    @Autowired
    GetTitlePort getTitlePort;

    @Override
    public Titre getTitle(String titleId) {
        return getTitlePort.getTitle(titleId);
    }
}
