package fr.gouv.mte.capqualif.legislateur.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.application.services.ParseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConditionTest {

    ParseService parseService;

    @BeforeEach
    void initialize() {
        parseService = new ParseService();
    }

    @Test
    void shouldEvaluateCorrectly() throws IOException {
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueAll.json")).isAreConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueFormationModulaire.json")).isAreConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivFormationModulaire.json")).isAreConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueCFBS.json")).isAreConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivCFBS.json")).isAreConditionsSatisfied());

        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseAgeWrong.json")).isAreConditionsSatisfied());
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseFormationWrong.json")).isAreConditionsSatisfied());
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseCFBSWrong.json")).isAreConditionsSatisfied());
    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }

}