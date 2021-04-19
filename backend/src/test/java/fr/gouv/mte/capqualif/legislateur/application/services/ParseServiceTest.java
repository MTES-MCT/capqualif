package fr.gouv.mte.capqualif.legislateur.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.domain.ParseResult;
import fr.gouv.mte.capqualif.legislateur.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParseServiceTest {

    ParseService parseService;

    @BeforeEach
    void init() {
        parseService = new ParseService();
    }

    @Test
    void shouldReturnAgeError() throws IOException {
        // When
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseAgeWrong.json")).getErrors();

        // Then
        List<String> expected = Arrays.asList(
                "age condition"
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCompetenceEnSecuriteError() throws IOException {
        // When
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseCFBSWrong.json")).getErrors();

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
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseFormationWrong.json")).getErrors();

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
        List<String> actual = parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivCFBS.json")).getErrors();

        // Then
        List<String> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }


}