package fr.gouv.mte.capqualif.instructeur.adapters.in.web;

import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instructeur.application.services.CompareSailorDataToTitleConditionsService;
import fr.gouv.mte.capqualif.instructeur.application.services.DataFinder;
import fr.gouv.mte.capqualif.marin.domain.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conditions")
public class CompareMarinDataToTitreConditionsController {

    @Autowired
    DataFinder dataFinder;

    @GetMapping("/test")
    public JsonObject compareSailorDataToTitleConditions () {
        return dataFinder.findMatchingMarinData("esculape", "123");
    }

    // déclencher

}
