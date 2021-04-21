package fr.gouv.mte.capqualif.legislateur.application.services;

import fr.gouv.mte.capqualif.legislateur.domain.Condition;
import fr.gouv.mte.capqualif.legislateur.domain.Marin;
import fr.gouv.mte.capqualif.legislateur.domain.ParseResult;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParseService {

    private JsonPopulator jsonPopulator;

    public ParseService(JsonPopulator jsonPopulator) {
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
        List<String> errors = new ArrayList<>();
        return new ParseResult(areConditionsSatisfied(condition, errors), getErrors(errors));
    }

    private boolean areConditionsSatisfied(Condition condition, List<String> errors) {
        return condition.validate(errors);
    }

    private List<String> getErrors(List<String> errors) {
        System.out.println(errors);
        return errors;
    }


}