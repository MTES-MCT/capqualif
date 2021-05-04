package fr.gouv.mte.capqualif.capadmin.adapters.in.web;

import fr.gouv.mte.capqualif.capadmin.application.ports.in.CreateTitreUseCase;
import fr.gouv.mte.capqualif.capadmin.application.services.temp.EvaluationService;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capadmin")
@CrossOrigin(origins = "http://localhost:3000")
public class ConditionsController {

    @Autowired
    CreateTitreUseCase createTitreUseCase;


    @PostMapping("/titres")
    public void testRes(@RequestBody Titre titre) {
        createTitreUseCase.createTitre(titre);
    }


    // TO DO : temp, remove later
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/evaluate")
    public void testEvaluation(@RequestBody Titre titre) {
        evaluationService.processTitre(titre, null);
    }


}