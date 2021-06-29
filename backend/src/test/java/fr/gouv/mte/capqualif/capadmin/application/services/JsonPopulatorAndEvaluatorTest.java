package fr.gouv.mte.capqualif.capadmin.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Data;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Marin;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonPopulatorAndEvaluatorTest {

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
                new Data<String>("aptitude", "1"),
                new Data<List<String>>("formations", Arrays.asList("P1–Appui-Navigation"
                        , "P2–Appui-Manutention/arrimage cargaison/pêche")),
                new Data<List<String>>("titres", Arrays.asList("Certificat de sensibilisation à la sûreté (STCW10)"))
            )
        );

        Titre notPopulatedYet = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/certificatDeMatelotPont_toPopulate.json");

        // When
        Titre actual = jsonPopulator.populate(notPopulatedYet, marin);

        // Then
        Titre expected = jsonToTitre("src/test/resources/mocks/capAdmin/conditions/certificatDeMatelotPont_ToPopulateExpected.json");

        assertEquals(expected, actual);


    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(location), Titre.class);
    }

}