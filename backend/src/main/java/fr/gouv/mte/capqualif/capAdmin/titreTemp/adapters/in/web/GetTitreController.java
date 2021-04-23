package fr.gouv.mte.capqualif.capAdmin.titreTemp.adapters.in.web;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.in.GetTitreUseCase;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titres")
@CrossOrigin(origins = "http://localhost:3000")
public class GetTitreController {

    @Autowired
    GetTitreUseCase getTitreUseCase;

    @GetMapping("/{titreId}")
    public Titre getTitre(@PathVariable("titreId") String titreId) {
        return getTitreUseCase.getTitre(titreId);
    }

}
