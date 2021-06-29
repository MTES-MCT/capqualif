package fr.gouv.mte.capqualif.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonConverter {

    public Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }

}
