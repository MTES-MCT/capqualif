package fr.gouv.mte.capqualif.capAdmin.adapters.in.web;

import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.ConditionEntity;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.ConditionRepository;
import fr.gouv.mte.capqualif.capAdmin.application.services.ParseService;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capadmin")
@CrossOrigin(origins = "http://localhost:3000")
public class ConditionsController {

    @Autowired
    private ParseService parseService;

    @Autowired
    private ConditionRepository conditionRepository;

    public ConditionsController(ParseService parseService) {
        this.parseService = parseService;
    }

    @GetMapping
    public List<ConditionEntity> getAllConditions() {
        return this.conditionRepository.findAll();
    }

    @PostMapping("/conditions")
    public void createTitreConditions(@RequestBody Titre titre) {

    }

    @PostMapping("/conditions")
    public void testEvaluation(@RequestBody Titre titre) {
        parseService.processTitre(titre, null);
    }

}