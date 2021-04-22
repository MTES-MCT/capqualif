package fr.gouv.mte.capqualif.capAdmin.titre.application.services;

import fr.gouv.mte.capqualif.capAdmin.titre.application.ports.in.GetAllTitresUseCase;
import fr.gouv.mte.capqualif.capAdmin.titre.application.ports.out.GetAllTitresPort;
import fr.gouv.mte.capqualif.capAdmin.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitresService implements GetAllTitresUseCase {

    @Autowired
    GetAllTitresPort getAllTitresPort;

    @Override
    public List<Titre> getAllTitres() {
        return getAllTitresPort.getAllTitres();
    }

}
