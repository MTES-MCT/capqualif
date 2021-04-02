package fr.gouv.mte.capqualif.legislateur.application.services;

import fr.gouv.mte.capqualif.legislateur.domain.Condition;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.springframework.stereotype.Component;

@Component
public class ParseService {

    public boolean parseTitre(Titre titre) {
        System.out.println("\n" + titre);

        // There is only one condition in the list
        // (the list is only used for deserialization purposes)
        // TO DO : move to controller ?
        Condition condition = titre.getConditions().get(0);
        boolean result = condition.validate();

//        if (!result) System.out.println("error of parseTitre " + condition.getError());
        System.out.println("Finally, " + condition.getId() + " is " + result + ".");
        return result;
    }
}