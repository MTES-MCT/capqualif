package fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.in;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;

import java.util.List;

public interface GetAllTitresUseCase {

    List<Titre> getAllTitres();

}
