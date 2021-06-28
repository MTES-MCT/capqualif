package fr.gouv.mte.capqualif.capqualif.instruction.adapters.in.web;

import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instruction")
@CrossOrigin(origins = "http://localhost:3000")
public class CompareMarinDataToConditionsTitreController {

    @Autowired
    private final CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;

    public CompareMarinDataToConditionsTitreController(CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase) {
        this.compareMarinDataToConditionsTitreUseCase = compareMarinDataToConditionsTitreUseCase;
    }

    @GetMapping("/evaluations/{numeroDeMarin}")
    public void compareMarinDataToTitreConditions(@PathVariable("numeroDeMarin") String numeroDeMarin) {
        compareMarinDataToConditionsTitreUseCase.compareMarinDataToConditionsTitre(numeroDeMarin);
    }

}