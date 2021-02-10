package fr.gouv.mte.capqualif.titre.application.ports.out;

import fr.gouv.mte.capqualif.titre.domain.Titre;

import java.util.List;

public interface GetAllTitresPort {

    List<Titre> getAllTitres();

}