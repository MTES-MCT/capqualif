package fr.gouv.mte.capqualif.instructeur.adapters.in.web;

import fr.gouv.mte.capqualif.instructeur.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instructeur.domain.CompareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instruction/comparaison")
public class CompareMarinDataToConditionsTitreController {

    @Autowired
    CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;

//    @Autowired
//    DataFinder dataFinder;

    @GetMapping("/{titreId}/{numeroDeMarin}")
    public List<CompareResult> compareSailorDataToTitleConditions(
            @PathVariable("titreId") String titreId,
            @PathVariable("numeroDeMarin") String numeroDeMarin) {
        return compareMarinDataToConditionsTitreUseCase.compareMarinDataToConditionsTitre(titreId, numeroDeMarin);
    }


}
