package fr.gouv.mte.capqualif.title.application.ports.out;

import fr.gouv.mte.capqualif.title.domain.Title;

import java.util.List;

public interface GetAllTitlesPort {

    List<Title> getAllTitles();

}