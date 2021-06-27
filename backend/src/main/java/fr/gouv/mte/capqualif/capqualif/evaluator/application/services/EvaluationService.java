package fr.gouv.mte.capqualif.capqualif.evaluator.application.services;

import fr.gouv.mte.capqualif.capadmin.application.services.JsonPopulator;
import fr.gouv.mte.capqualif.capadmin.domain.*;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Marin;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

@Component
public class EvaluationService {

    private final JsonPopulator jsonPopulator;
    private final static Logger LOGGER = Logger.getLogger(EvaluationService.class.getName());

    public EvaluationService(JsonPopulator jsonPopulator) {
        this.jsonPopulator = jsonPopulator;
    }


    public GlobalResult canMarinHaveTitre(Titre titre, Marin marin) {
        if (marin != null) {
            try {
                titre = jsonPopulator.populate(titre, marin);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, e.toString());
            }
        }

        // There is only one condition in the list
        // (the list is only used for deserialization purposes)
        Condition condition = titre.getConditions().get(0);
        List<ConditionResult> detailedResults = new ArrayList<>();
        GlobalResult result = new GlobalResult(areConditionsSatisfied(condition, detailedResults), detailedResults);
        System.out.println(detailedResults);
        System.out.println(result);
        return result;
    }

    private boolean areConditionsSatisfied(Condition condition, List<ConditionResult> detailedResults) {
        return condition.validate(detailedResults);
    }

}