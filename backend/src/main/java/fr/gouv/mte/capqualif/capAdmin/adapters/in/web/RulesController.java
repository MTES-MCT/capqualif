package fr.gouv.mte.capqualif.capAdmin.adapters.in.web;

import fr.gouv.mte.capqualif.capAdmin.application.services.ParseService;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legislateur")
@CrossOrigin(origins = "http://localhost:3000")
public class RulesController {

    @Autowired
    private ParseService parseService;

    public RulesController(ParseService parseService) {
        this.parseService = parseService;
    }

//    @PostMapping("/conditions")
//    public void createConditions(@RequestBody Titre titre) {
//
////        parseService.processTitre(titre);
//    }

    @PostMapping("/conditions")
    public void testEvaluation(@RequestBody Titre titre) {
        parseService.processTitre(titre, null);
    }

}