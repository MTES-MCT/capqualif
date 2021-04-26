package fr.gouv.mte.capqualif.capAdmin.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capAdmin.domain.ConditionIdentity;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluationServiceErrorsTest {

    EvaluationService evaluationService;
    JsonPopulator jsonPopulator;

    @BeforeEach
    void init() {
        evaluationService = new EvaluationService(new JsonPopulator());
    }

    //====================== Tests on conditions populated with hardcoded values ====================================================//

    @Test
    void shouldReturnAgeError() throws IOException {
        // When
        List<ConditionIdentity> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseAgeWrong.json"), null).getErrors();

        // Then
        List<ConditionIdentity> expected = Collections.singletonList(
                new ConditionIdentity("age","age")
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCompetenceEnSecuriteError() throws IOException {
        // When
        List<ConditionIdentity> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseCFBSWrong.json"), null).getErrors();

        // Then
        List<ConditionIdentity> expected = Arrays.asList(
                new ConditionIdentity("titre mainstream", "compétences en sécurité"),
                new ConditionIdentity("document reconnu équivalent au CFBS 2014", "compétences en sécurité"),
                new ConditionIdentity("document reconnu équivalent au CFBS 2015", "compétences en sécurité")
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllFormationsError() throws IOException {
        // When
        List<ConditionIdentity> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseFormationWrong.json"), null).getErrors();

        // Then
        List<ConditionIdentity> expected = Arrays.asList(
                new ConditionIdentity("module de formation modulaire P1", "formations modulaires"),
                new ConditionIdentity("module de formation modulaire P2", "formations modulaires"),
                new ConditionIdentity("titre reconnu équivalent à la formation modulaire 2006", "titres reconnus équivalents à la formation modulaire"),
                new ConditionIdentity("titre reconnu équivalent à la formation modulaire 2005", "titres reconnus équivalents à la formation modulaire")
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnErrorsForCompetenceSecuButNotForFormation() throws IOException {
        // When
        List<ConditionIdentity> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseBecauseCompetenceSecuIsMissingButFormationsModulairesOk.json"), null).getErrors();

        // Then
        List<ConditionIdentity> expected = Arrays.asList(
                new ConditionIdentity("titre mainstream", "compétences en sécurité"),
                new ConditionIdentity("document reconnu équivalent au CFBS 2014", "compétences en sécurité"),
                new ConditionIdentity("document reconnu équivalent au CFBS 2015", "compétences en sécurité")
        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNoErrorsForCompetencesEnSecurite() throws IOException {
        // When
        List<ConditionIdentity> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/trueEquivCFBS.json"), null).getErrors();

        // Then
        List<ConditionIdentity> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }

    //===============================================================================================================================//
    //====================== Tests on conditions populated with marin values ====================================================//



    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }


}