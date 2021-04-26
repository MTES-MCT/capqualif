package fr.gouv.mte.capqualif.capAdmin.application.services;

import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.ConditionIdentity;
import fr.gouv.mte.capqualif.capAdmin.domain.Marin;
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

        // There is only one condition in the list
        // (the list is only used for deserialization purposes)
        // TO DO : move to controller ?
        if (marin != null) {
            try {
                jsonPopulator.populate(titre, marin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Condition condition = titre.getConditions().get(0);
        List<ConditionIdentity> conditionIdentities = new ArrayList<>();
        return new ParseResult(areConditionsSatisfied(condition, conditionIdentities), getErrors(conditionIdentities));
    }

    private boolean areConditionsSatisfied(Condition condition, List<ConditionIdentity> conditionIdentities) {
        return condition.validate(conditionIdentities);
    }

    private List<ConditionIdentity> getErrors(List<ConditionIdentity> conditionIdentities) {
        return conditionIdentities;
    }


}