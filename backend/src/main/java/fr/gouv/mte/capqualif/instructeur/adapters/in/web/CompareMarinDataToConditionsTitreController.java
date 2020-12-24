package fr.gouv.mte.capqualif.instructeur.adapters.in.web;

import fr.gouv.mte.capqualif.instructeur.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instructeur.domain.CompareResult;
import fr.gouv.mte.capqualif.utils.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/instruction/comparaison")
@CrossOrigin
public class CompareMarinDataToConditionsTitreController {

    @Autowired
    CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;

    @Autowired
    TimeConverter timeConverter;

    @GetMapping("/{titreId}/{numeroDeMarin}")
    public List<CompareResult> compareSailorDataToTitleConditions(
            @PathVariable("titreId") String titreId,
            @PathVariable("numeroDeMarin") String numeroDeMarin) {
        return compareMarinDataToConditionsTitreUseCase.compareMarinDataToConditionsTitre(titreId, numeroDeMarin);
    }

//    @GetMapping("/date")
//    public void compareSailorDataToTitleConditions() {
//        timeConverter.convertStringDateToLocalDate("25/05/1985");
//    }


}
