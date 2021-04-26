package fr.gouv.mte.capqualif.capAdmin.adapters.in.web;


//import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.ConditionJpaEntity;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.*;
//import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreJpaEntity;
import fr.gouv.mte.capqualif.capAdmin.application.services.EvaluationService;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.DatabaseActions;
import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capadmin")
@CrossOrigin(origins = "http://localhost:3000")
public class ConditionsController {

    @Autowired
    private final EvaluationService evaluationService;

    @Autowired
    private TitreMapper titreMapper;

    @Autowired
    private ConditionMapper conditionMapper;

    @Autowired
    private TitreRepository titreRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    DatabaseActions databaseActions;

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

    @PostMapping("/reserialize")
    public void testRes(@RequestBody Titre titre) {
        databaseActions.save(titre);
    }

    @GetMapping("/deserialize/{id}")
    public void desAndEv(@PathVariable Long id) {
        databaseActions.find(id);
    }

    @PostMapping("/map-conditions")
    public void map(@RequestBody Condition condition) {
        ConditionJpaEntity conditions = conditionMapper.mapToJpaEntity(condition);
//        System.out.println(conditions);
//        return this.conditionRepository.save(conditions);
    }

//    @PostMapping("/map-titre")
//    public TitreJpaEntity map(@RequestBody Titre titre) {
//        TitreJpaEntity titreJpaEntity = titreMapper.mapToJpaEntity(titre);
//        System.out.println(titreJpaEntity);
//        return this.titreRepository.save(titreJpaEntity);
//    }


}