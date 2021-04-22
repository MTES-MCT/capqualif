package fr.gouv.mte.capqualif.capAdmin.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParseServiceErrorsTest {

    ParseService parseService;
    JsonPopulator jsonPopulator;

    @BeforeEach
    void init() {
        parseService = new ParseService(new JsonPopulator());
    }

    //====================== Tests on conditions populated with hardcoded values ====================================================//

    @Test
    void shouldReturnAgeError() throws IOException {
        // When
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseAgeWrong.json"), null).getErrors();

        // Then
        List<String> expected = Collections.singletonList(
                "age condition"
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCompetenceEnSecuriteError() throws IOException {
        // When
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseCFBSWrong.json"), null).getErrors();

        // Then
        List<String> expected = Arrays.asList(
                "titre CFBS mainstream",
                "document reconnu équivalent au CFBS 2014",
                "document reconnu équivalent au CFBS 2015"
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllFormationsError() throws IOException {
        // When
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseFormationWrong.json"), null).getErrors();

        // Then
        List<String> expected = Arrays.asList(
                "module de formation modulaire P1",
                "module de formation modulaire P2",
                "titre reconnu équivalent à la formation modulaire 2006",
                "titre reconnu équivalent à la formation modulaire 2005"
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNoErrorsForCompetencesEnSecurite() throws IOException {
        // When
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/trueEquivCFBS.json"), null).getErrors();

        // Then
        List<String> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }

    //===============================================================================================================================//
    //====================== Tests on conditions populated with hardcoded values ====================================================//



    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }


}