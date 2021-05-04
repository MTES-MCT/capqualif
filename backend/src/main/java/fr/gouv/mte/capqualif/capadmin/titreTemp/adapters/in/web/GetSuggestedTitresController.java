package fr.gouv.mte.capqualif.capadmin.titreTemp.adapters.in.web;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.Titre;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/titres")
@CrossOrigin(origins = "http://localhost:3000")
public class GetSuggestedTitresController {

    @GetMapping("/suggested-titres")
    public List<Titre> getSuggestedTitres() {
        return null;
    }

}
