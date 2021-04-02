package fr.gouv.mte.capqualif.legislateur.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.application.services.ParseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConditionTest {

    ParseService parseService;

    @BeforeEach
    void initialize() {
        parseService = new ParseService();
    }

    @Test
    void shouldEvaluateCorrectly() throws IOException {
        assertTrue(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueAll.json")));
        assertTrue(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueFormationModulaire.json")));
        assertTrue(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivFormationModulaire.json")));
        assertTrue(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueCFBS.json")));
        assertTrue(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivCFBS.json")));

        assertFalse(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseAgeWrong.json")));
        assertFalse(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseFormationWrong.json")));
        assertFalse(parseService.parseTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseCFBSWrong.json")));
    }

    @Test
    void shouldHaveTheRightErrors() {
        // Given

        // When
        // Then
    }


    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }

}