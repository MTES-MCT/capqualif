package fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.out;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.Titre;

import java.util.List;

public interface GetAllTitresPort {

    List<Titre> getAllTitres();

}