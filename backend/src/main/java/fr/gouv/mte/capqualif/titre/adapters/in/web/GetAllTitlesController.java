package fr.gouv.mte.capqualif.titre.adapters.in.web;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetAllTitlesUseCase;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titles")
@CrossOrigin
public class GetAllTitlesController {

    @Autowired
    GetAllTitlesUseCase getAllTitlesUseCase;

    @GetMapping("/titles")
    public List<Titre> getAllTitles() {
        return getAllTitlesUseCase.getAllTitles();
    }

}



