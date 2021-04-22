package fr.gouv.mte.capqualif.domain.capAdmin.titre.application.ports.in;

import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.Titre;

import java.util.List;

public interface GetAllTitresUseCase {

    List<Titre> getAllTitres();

}
