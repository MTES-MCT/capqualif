package fr.gouv.mte.capqualif.capAdmin.titre.application.ports.in;

import fr.gouv.mte.capqualif.capAdmin.titre.domain.Titre;

import java.util.List;

public interface GetAllTitresUseCase {

    List<Titre> getAllTitres();

}
