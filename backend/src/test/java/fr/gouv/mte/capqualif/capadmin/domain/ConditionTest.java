package fr.gouv.mte.capqualif.capadmin.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capadmin.application.services.JsonPopulator;
import fr.gouv.mte.capqualif.capqualif.evaluator.application.services.EvaluationService;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Data;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Marin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConditionTest {

    EvaluationService evaluationService;
    JsonPopulator jsonPopulator;

    @BeforeEach
    void initialize() {
        evaluationService = new EvaluationService(new JsonPopulator());
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
                        ),
                        new Data<List<String>>(
                                "titres",
                                Collections.singletonList(
                                        "CFBS"
                                )
                        )
                )
        );

        // When & Then
        assertTrue(evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
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
                        ),
                        new Data<List<String>>(
                                "titres",
                                Collections.singletonList(
                                        "CFBS"
                                )
                        )
                )
        );

        // When & Then
        assertFalse(evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
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
                        ),
                        new Data<List<String>>(
                                "titres",
                                Collections.singletonList(
                                        "CFBS"
                                )
                        )
                )
        );

        // When & Then
        assertFalse(evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
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
                        ),
                        new Data<List<String>>(
                                "titres",
                                Collections.singletonList(
                                        "CFBS"
                                )
                        )
                )
        );

        // When & Then
        assertFalse(evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
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
                                Collections.singletonList(
                                        "Certificat de fin d’études maritimes de matelot, de marin du commerce ou " +
                                                "“pêche” délivré conformément à l’arrêté du 12 décembre 2006 susvisé"
                                )
                        ),
                        new Data<List<String>>(
                                "titres",
                                Collections.singletonList(
                                        "CFBS"
                                )
                        )
                )
        );

        // When & Then
        assertTrue(evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json")
                , marin).areConditionsSatisfied());

    }


    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }

}