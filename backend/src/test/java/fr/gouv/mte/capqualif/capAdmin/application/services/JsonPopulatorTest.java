package fr.gouv.mte.capqualif.capAdmin.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capAdmin.domain.Data;
import fr.gouv.mte.capqualif.capAdmin.domain.Marin;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonPopulatorTest {

    JsonPopulator jsonPopulator;

    @BeforeEach
    void init() {
        jsonPopulator = new JsonPopulator();
    }

    @Test
    public void shouldPopulateWithData() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "21"),
                new Data<String>("aptitude", "apte"),
                new Data<List<String>>("formations", Arrays.asList("Module P1-Appui navigation"
                        , "Module P2-Appui manutention et arrimage de la cargaison, pêche")),
                new Data<List<String>>("titres", Arrays.asList("CFBS"))
            )
        );

        Titre notPopulatedYet = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json");

        // When
        Titre actual = jsonPopulator.populate(notPopulatedYet, marin);

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