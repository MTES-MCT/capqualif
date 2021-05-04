package fr.gouv.mte.capqualif.capadmin.application.services;

import fr.gouv.mte.capqualif.capadmin.domain.Condition;
import fr.gouv.mte.capqualif.capadmin.domain.temp.Marin;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
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