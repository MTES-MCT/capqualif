package fr.gouv.mte.capqualif.comparateur.application.ports.out;

import fr.gouv.mte.capqualif.title.domain.Title;

public interface GetTitlePort {

    Title getTitle(String titleId);

}
