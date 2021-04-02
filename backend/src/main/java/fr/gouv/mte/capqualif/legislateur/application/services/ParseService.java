package fr.gouv.mte.capqualif.legislateur.application.services;

import fr.gouv.mte.capqualif.legislateur.domain.Condition;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.springframework.stereotype.Component;

@Component
public class ParseService {

    public boolean parseTitre(Titre titre) {
        System.out.println("\n" + titre);

        int i = 0;
        for (Condition condition : titre.getConditions()) {
           boolean result = condition.validate();
            if (i++ == titre.getConditions().size() - 1)
                System.out.println("Finally, " + condition.getId() + " is " + result);
            return result;
        }
        System.out.println("outside conditions loop");
        return false;
    }
}