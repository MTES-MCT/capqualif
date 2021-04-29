package fr.gouv.mte.capqualif.capAdmin.application.services;

import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.temp.Marin;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonPopulator {

    public Titre populate(Titre sourceTitre, Marin marin) throws IOException {
        Titre titre = new Titre(sourceTitre);
        Condition conditions = titre.getConditions().get(0);
        conditions.populateWithData(marin);
        return titre;
    }
}