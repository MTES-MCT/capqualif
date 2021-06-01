package fr.gouv.mte.capqualif.capadmin.application.services.temp;

import fr.gouv.mte.capqualif.capadmin.application.services.JsonPopulator;
import fr.gouv.mte.capqualif.capadmin.domain.*;
import fr.gouv.mte.capqualif.capadmin.domain.temp.Marin;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Component
public class EvaluationService {

    private final JsonPopulator jsonPopulator;
    private final static Logger LOGGER = Logger.getLogger(EvaluationService.class.getName());


    public EvaluationService(JsonPopulator jsonPopulator) {
        this.jsonPopulator = jsonPopulator;
    }


    public ParseResult processTitre(Titre titre, Marin marin) {
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
        List<ConditionIdentity> allErrors = new ArrayList<>();
        ParseResult result = new ParseResult(areConditionsSatisfied(condition, allErrors), getErrors(allErrors));
        logResults(result);
        return result;
    }

    private boolean areConditionsSatisfied(Condition condition, List<ConditionIdentity> conditionIdentities) {
        return condition.validate(conditionIdentities);
    }

    private List<ConditionIdentity> getErrors(List<ConditionIdentity> errors) {
        return errors;
    }

    // TO DO : temp, remove later
    private void logResults(ParseResult result) {
        if (result.areConditionsSatisfied()) {
            System.out.println("\nxxxxxxxxxxxxx C'est parfait, vous remplissez les conditions pour obtenir ce titre. xxxxxxxxxxxx\n");
        } else {
            System.out.println("\nxxxxxxxxxxxxx Vous ne remplissez les conditions pour obtenir ce titre. xxxxxxxxxxxx\n");
        }

        if (!result.areConditionsSatisfied()) {
            Map<Group, List<ConditionIdentity>> errorsByGroup = result.getErrors().stream().collect(groupingBy(ConditionIdentity::getGroup, toList()));
            for (Map.Entry<Group, List<ConditionIdentity>> errorGroup : errorsByGroup.entrySet()) {
                if (errorGroup.getKey().getOperator().equals(Operator.OR)) {
                    System.out.println("*************** Avez-vous l'un de ces documents ? ***************");
                    for (ConditionIdentity error : errorGroup.getValue()) {
                        System.out.println("****************************** " + error.getName() + " ? ***************");
                    }
                }
                if (errorGroup.getKey().getOperator().equals(Operator.AND)) {
                    System.out.println("*************** Avez-vous ces documents ? ***************");
                    for (ConditionIdentity error : errorGroup.getValue()) {
                        System.out.println("****************************** " + error.getName() + " ? ***************");
                    }
                }
            }
        }
    }


}