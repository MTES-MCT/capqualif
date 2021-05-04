package fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.out;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;

import java.util.List;

public interface GetAllTitresPort {

    List<Titre> getAllTitres();

}