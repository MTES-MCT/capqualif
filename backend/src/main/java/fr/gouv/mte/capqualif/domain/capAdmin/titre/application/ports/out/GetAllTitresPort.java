package fr.gouv.mte.capqualif.domain.capAdmin.titre.application.ports.out;

import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.Titre;

import java.util.List;

public interface GetAllTitresPort {

    List<Titre> getAllTitres();

}