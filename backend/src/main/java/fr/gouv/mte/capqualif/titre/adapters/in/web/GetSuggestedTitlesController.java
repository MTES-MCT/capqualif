package fr.gouv.mte.capqualif.titre.adapters.in.web;

import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/titles")
@CrossOrigin(origins = "http://localhost:3000")
public class GetSuggestedTitlesController {

    @GetMapping("/suggested-titles")
    public List<Titre> getSuggestedTitles() {
        return null;
    }

}
