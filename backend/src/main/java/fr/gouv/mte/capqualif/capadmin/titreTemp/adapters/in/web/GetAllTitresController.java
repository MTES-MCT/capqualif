package fr.gouv.mte.capqualif.capadmin.titreTemp.adapters.in.web;

import fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.in.GetAllTitresUseCase;
import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/titres")
@CrossOrigin(origins = "http://localhost:3000")
public class GetAllTitresController {

    @Autowired
    GetAllTitresUseCase getAllTitresUseCase;

    @GetMapping("/titres")
    public List<Titre> getAllTitres() {
        return getAllTitresUseCase.getAllTitres();
    }

}



