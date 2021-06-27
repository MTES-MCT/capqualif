package fr.gouv.mte.capqualif.capqualif.instruction.adapters.in.web.archive;

import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSource;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.JuridicalDesignations;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ComparisonsSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/instruction")
@CrossOrigin(origins = "http://localhost:3000")
public class CompareMarinDataToConditionsTitreController {

    @Autowired
    private final CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;

    public CompareMarinDataToConditionsTitreController(CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase) {
        this.compareMarinDataToConditionsTitreUseCase = compareMarinDataToConditionsTitreUseCase;
    }

    @GetMapping("/{titreId}/{numeroDeMarin}")
    public void compareMarinDataToTitreConditions(@PathVariable("titreId") String titreId, @PathVariable("numeroDeMarin") String numeroDeMarin) {
        compareMarinDataToConditionsTitreUseCase.compareMarinDataToConditionsTitre(titreId, numeroDeMarin);
    }

}