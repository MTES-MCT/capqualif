package fr.gouv.mte.capqualif.capAdmin.adapters.in.web;


//import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.ConditionJpaEntity;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.ConditionJpaEntity;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.ConditionMapper;
//import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreJpaEntity;
//import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreRepository;
import fr.gouv.mte.capqualif.capAdmin.application.services.EvaluationService;
import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/capadmin")
@CrossOrigin(origins = "http://localhost:3000")
public class ConditionsController {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private ConditionMapper conditionMapper;

//    @Autowired
//    private TitreRepository titreRepository;

    public ConditionsController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

//    @GetMapping
//    public List<TitreJpaEntity> getAllTitres() {
//        return this.titreRepository.findAll();
//    }

//    @PostMapping("/titres-conditions")
//    public TitreJpaEntity createTitreConditions() {
//        ConditionJpaEntity condition = new ConditionJpaEntity(
//                ""
//        )
//        return this.titreRepository.save(new TitreJpaEntity("titre de mangeur de patates"));
//    }

    @PostMapping("/evaluate")
    public void testEvaluation(@RequestBody Titre titre) {
        evaluationService.processTitre(titre, null);
    }

    @PostMapping("/map")
    public void map(@RequestBody Condition condition) {

        ConditionJpaEntity conditions = conditionMapper.mapToJpaEntity(condition);
        System.out.println(conditions);
    }


}