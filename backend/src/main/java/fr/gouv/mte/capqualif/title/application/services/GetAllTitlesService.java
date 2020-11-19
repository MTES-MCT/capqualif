package fr.gouv.mte.capqualif.title.application.services;

import fr.gouv.mte.capqualif.title.application.ports.in.GetAllTitlesUseCase;
import fr.gouv.mte.capqualif.title.application.ports.out.GetAllTitlesPort;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitlesService implements GetAllTitlesUseCase {

    @Autowired
    GetAllTitlesPort getAllTitlesPort;

    @Override
    public List<Title> getAllTitles() {
        return getAllTitlesPort.getAllTitles();
    }

}
