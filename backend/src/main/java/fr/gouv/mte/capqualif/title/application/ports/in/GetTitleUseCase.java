package fr.gouv.mte.capqualif.title.application.ports.in;

import fr.gouv.mte.capqualif.title.domain.Title;

public interface GetTitleUseCase {

    Title getTitle(String titleId);

}
