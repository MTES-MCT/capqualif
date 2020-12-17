package fr.gouv.mte.capqualif.titre.application.ports.in;

import fr.gouv.mte.capqualif.titre.domain.Titre;

import java.util.List;

public interface GetAllTitlesUseCase {

    List<Titre> getAllTitles();

}
