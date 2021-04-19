package fr.gouv.mte.capqualif.legislateur.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.domain.Condition;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class PopulateJsonService {

    public Titre populate(Titre notPopulatedYet) throws IOException {
        // Prendre la valeur de leftOp (age) et la chercher dans l'objet marin

        for (Condition condition : notPopulatedYet.getConditions()) {
            System.out.println(condition.getId());
        }

        // Remplacer la valeur de leftOp par la valeur récupérée chez le marin

        return jsonToTitre("src/test/resources/mocks/capAdmin/conditions/expectedAgeToPopulate.json");
    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        return titre;
    }
}