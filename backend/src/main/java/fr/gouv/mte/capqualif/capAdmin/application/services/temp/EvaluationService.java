package fr.gouv.mte.capqualif.capAdmin.application.services.temp;

import fr.gouv.mte.capqualif.capAdmin.application.services.JsonPopulator;
import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.ConditionIdentity;
import fr.gouv.mte.capqualif.capAdmin.domain.temp.Marin;
import fr.gouv.mte.capqualif.capAdmin.domain.ParseResult;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EvaluationService {

    private final JsonPopulator jsonPopulator;

    public EvaluationService(JsonPopulator jsonPopulator) {
        this.jsonPopulator = jsonPopulator;
    }


    public ParseResult processTitre(Titre titre, Marin marin) {
        if (marin != null) {
            try {
                jsonPopulator.populate(titre, marin);
            } catch (IOException e) {
                e.printStackTrace();
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
        System.out.println("\n *************** Evaluation result is " + result.areConditionsSatisfied() + " ***************");
        if (!result.areConditionsSatisfied()) {

            for (ConditionIdentity error : result.getErrors()) {
                System.out.println(error.getGroup());
                System.out.println("*************** \uD83D\uDE3F Avez-vous un document pour " + error.getName() + " \uD83D\uDE3F ? ***************");
            }
        }
    }


}