package fr.gouv.mte.capqualif.capAdmin.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capAdmin.application.services.JsonPopulator;
import fr.gouv.mte.capqualif.capAdmin.application.services.ParseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConditionEntityTest {

    ParseService parseService;
    JsonPopulator jsonPopulator;

    @BeforeEach
    void initialize() {
        parseService = new ParseService(new JsonPopulator());
    }

    @Test
    void shouldEvaluateCorrectlyNotPopulatedJson() throws IOException {
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueAll.json")
                , null).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/trueFormationModulaire.json"), null).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/trueEquivFormationModulaire.json"), null).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueCFBS.json"), null).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/trueEquivCFBS" +
                ".json"), null).areConditionsSatisfied());
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/trueBecauseFormationsContainsAllFormationsModulaires.json"), null).areConditionsSatisfied());

        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/falseAgeWrong" +
                ".json"), null).areConditionsSatisfied());
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseFormationWrong.json"), null).areConditionsSatisfied());
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions" +
                "/falseCFBSWrong.json"), null).areConditionsSatisfied());
    }

    @Test
    void shouldEvaluateTrueBecauseMarinSatisfiesConditions() throws IOException {
        // Given
        Marin marin = new Marin(
                Arrays.asList(
                        new Data<String>("age", "21"),
                        new Data<String>("aptitude", "apte"),
                        new Data<List<String>>(
                                "formations",
                                Arrays.asList(
                                        "Module P1-Appui navigation",
                                        "Module P2-Appui manutention et arrimage de la cargaison, pêche"
                                )
                        )
                )
        );

        // When & Then
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
                , marin).areConditionsSatisfied());

    }

    @Test
    void shouldEvaluateFalseBecauseMarinIsTooYoung() throws IOException {
        // Given
        Marin marin = new Marin(
                Arrays.asList(
                        new Data<String>("age", "14"),
                        new Data<String>("aptitude", "apte"),
                        new Data<List<String>>(
                                "formations",
                                Arrays.asList(
                                        "Module P1-Appui navigation",
                                        "Module P2-Appui manutention et arrimage de la cargaison, pêche"
                                )
                        )
                )
        );

        // When & Then
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
                , marin).areConditionsSatisfied());

    }

    @Test
    void shouldEvaluateFalseBecauseMarinIsNotApte() throws IOException {
        // Given
        Marin marin = new Marin(
                Arrays.asList(
                        new Data<String>("age", "21"),
                        new Data<String>("aptitude", "non apte"),
                        new Data<List<String>>(
                                "formations",
                                Arrays.asList(
                                        "Module P1-Appui navigation",
                                        "Module P2-Appui manutention et arrimage de la cargaison, pêche"
                                )
                        )
                )
        );

        // When & Then
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
                , marin).areConditionsSatisfied());

    }

    @Test
    void shouldEvaluateFalseBecauseMarinDoesNotHaveAllFormations() throws IOException {
        // Given
        Marin marin = new Marin(
                Arrays.asList(
                        new Data<String>("age", "21"),
                        new Data<String>("aptitude", "apte"),
                        new Data<List<String>>(
                                "formations",
                                Arrays.asList(
                                        "Module P1-Appui navigation"
                                )
                        )
                )
        );

        // When & Then
        assertFalse(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
                , marin).areConditionsSatisfied());

    }

    @Test
    void shouldEvaluateTrueBecauseMarinHasFormationEquivalences() throws IOException {
        // Given
        Marin marin = new Marin(
                Arrays.asList(
                        new Data<String>("age", "21"),
                        new Data<String>("aptitude", "apte"),
                        new Data<List<String>>(
                                "formations",
                                Arrays.asList(
                                        "Certificat de fin d’études maritimes de matelot, de marin du commerce ou “pêche” délivré conformément à l’arrêté du 12 décembre 2006 susvisé"
                                )
                        )
                )
        );

        // When & Then
        assertTrue(parseService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
                , marin).areConditionsSatisfied());

    }


    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }

}