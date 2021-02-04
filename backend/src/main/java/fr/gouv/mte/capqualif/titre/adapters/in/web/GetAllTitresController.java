package fr.gouv.mte.capqualif.titre.adapters.in.web;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetAllTitresUseCase;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titres")
@CrossOrigin
public class GetAllTitresController {

    @Autowired
    GetAllTitresUseCase getAllTitresUseCase;

    @GetMapping("/titres")
    public List<Titre> getAllTitres() {
        return getAllTitresUseCase.getAllTitres();
    }

}



