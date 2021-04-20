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
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueAll.json")).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueFormationModulaire.json")).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivFormationModulaire.json")).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueCFBS.json")).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivCFBS.json")).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueBecauseFormationsContainsAllFormationsModulaires.json")).areConditionsSatisfied());

        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseAgeWrong.json")).areConditionsSatisfied());
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseFormationWrong.json")).areConditionsSatisfied());
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseCFBSWrong.json")).areConditionsSatisfied());
    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }

}