package fr.gouv.mte.capqualif.capAdmin.titre.application.ports.out;

import fr.gouv.mte.capqualif.capAdmin.titre.domain.Titre;

import java.util.List;

public interface GetAllTitresPort {

    List<Titre> getAllTitres();

}