package fr.gouv.mte.capqualif.titre.adapters.in.web;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetTitreUseCase;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titres")
public class GetTitreController {

    @Autowired
    GetTitreUseCase getTitreUseCase;

    @GetMapping("/{titreId}")
    public Titre getTitre(@PathVariable("titreId") String titreId) {
        return getTitreUseCase.getTitre(titreId);
    }

}
