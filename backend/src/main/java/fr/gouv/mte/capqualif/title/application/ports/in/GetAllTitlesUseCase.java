package fr.gouv.mte.capqualif.title.application.ports.in;

import fr.gouv.mte.capqualif.title.domain.Title;

import java.util.List;

public interface GetAllTitlesUseCase {

    List<Title> getAllTitles();

}
