package fr.gouv.mte.capqualif.titre.adapters.in.web;

import fr.gouv.mte.capqualif.titre.application.ports.in.GetTitleUseCase;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titles")
@CrossOrigin
public class GetTitleController {

    @Autowired
    GetTitleUseCase getTitleUseCase;

    @GetMapping("/{titreId}")
    public Titre getTitle(@PathVariable("titreId") String titreId) {
        return getTitleUseCase.getTitle(titreId);
    }

}
