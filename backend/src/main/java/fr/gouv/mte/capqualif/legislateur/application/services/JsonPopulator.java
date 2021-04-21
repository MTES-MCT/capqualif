package fr.gouv.mte.capqualif.legislateur.application.services;

import fr.gouv.mte.capqualif.legislateur.domain.Condition;
import fr.gouv.mte.capqualif.legislateur.domain.Marin;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class JsonPopulator {

    public Titre populate(Titre notPopulatedYet, Marin marin) throws IOException {
        // Prendre la valeur de leftOp (age) et la chercher dans l'objet marin
        Condition condition = notPopulatedYet.getConditions().get(0);
        condition.populateWithData(marin);

        // Remplacer la valeur de leftOp par la valeur récupérée chez le marin
        return notPopulatedYet;
    }
}