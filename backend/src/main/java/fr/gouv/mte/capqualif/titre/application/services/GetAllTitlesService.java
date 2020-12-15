package fr.gouv.mte.capqualif.titre.application.services;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetAllTitlesUseCase;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetAllTitlesPort;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitlesService implements GetAllTitlesUseCase {

    @Autowired
    GetAllTitlesPort getAllTitlesPort;

    @Override
    public List<Titre> getAllTitles() {
        return getAllTitlesPort.getAllTitles();
    }

}
