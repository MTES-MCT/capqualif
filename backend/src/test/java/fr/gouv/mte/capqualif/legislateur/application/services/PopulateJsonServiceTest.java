package fr.gouv.mte.capqualif.legislateur.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.domain.Marin;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PopulateJsonServiceTest {

    PopulateJsonService populateJsonService;

    @BeforeEach
    void init() {
        populateJsonService = new PopulateJsonService();
    }

    @Test
    public void shouldPopulateWithData() throws IOException {

        // Given
//        Marin marin = new Marin("21");
        Map<String, String> data = new HashMap<>();
        data.put("age condition", "21");
        data.put("aptitude condition", "apte");
        Titre notPopulatedYet = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/ageToPopulate.json");

        // When
        Titre actual = populateJsonService.populate(notPopulatedYet, data);

        // Then
        Titre expected = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/expectedAgeToPopulate.json");

        assertEquals(expected, actual);


    }


    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        return titre;
    }

}