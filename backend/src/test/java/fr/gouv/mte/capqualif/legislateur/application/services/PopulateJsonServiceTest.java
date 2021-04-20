package fr.gouv.mte.capqualif.legislateur.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.domain.Data;
import fr.gouv.mte.capqualif.legislateur.domain.Marin;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopulateJsonServiceTest {

    PopulateJsonService populateJsonService;

    @BeforeEach
    void init() {
        populateJsonService = new PopulateJsonService();
    }

    @Test
    public void shouldPopulateWithData() throws IOException {

        // Given

        Marin marin = new Marin(Arrays.asList(new Data("age", "21"), new Data("aptitude", "apte")));
        Titre notPopulatedYet = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json");

        // When
        Titre actual = populateJsonService.populate(notPopulatedYet, marin);

        // Then
        Titre expected = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulateExpected.json");

        assertEquals(expected, actual);


    }


    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        return titre;
    }

}