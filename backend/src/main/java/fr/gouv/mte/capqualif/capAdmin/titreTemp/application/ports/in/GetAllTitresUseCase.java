package fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.in;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.Titre;

import java.util.List;

public interface GetAllTitresUseCase {

    List<Titre> getAllTitres();

}
