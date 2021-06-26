//package fr.gouv.mte.capqualif.capqualif.evaluator.adapters.in.web.archive;
//
//import fr.gouv.mte.capqualif.capqualif.evaluator.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
//import fr.gouv.mte.capqualif.capqualif.evaluator.domain.archive.ComparisonsSummary;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////@RestController
////@RequestMapping("/instruction/comparaison")
////@CrossOrigin(origins = "http://localhost:3000")
////public class CompareMarinDataToConditionsTitreController {
////
//////    @Autowired
//////    private final CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;
//////
//////    public CompareMarinDataToConditionsTitreController(CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase) {
//////        this.compareMarinDataToConditionsTitreUseCase = compareMarinDataToConditionsTitreUseCase;
//////    }
//////
//////    @GetMapping("/{titreId}/{numeroDeMarin}")
//////    public List<ComparisonsSummary> compareMarinDataToTitreConditions(@PathVariable("titreId") String titreId, @PathVariable("numeroDeMarin") String numeroDeMarin) {
//////        return compareMarinDataToConditionsTitreUseCase.compareMarinDataToConditionsTitre(titreId, numeroDeMarin);
//////    }
////
////}