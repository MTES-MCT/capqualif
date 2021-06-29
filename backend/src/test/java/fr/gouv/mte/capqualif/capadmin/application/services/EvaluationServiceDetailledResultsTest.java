package fr.gouv.mte.capqualif.capadmin.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capqualif.evaluator.application.services.EvaluationService;
import fr.gouv.mte.capqualif.capadmin.domain.*;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Data;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Marin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluationServiceDetailledResultsTest {

    EvaluationService evaluationService;
    JsonPopulator jsonPopulator;

    @BeforeEach
    void init() {
        evaluationService = new EvaluationService(new JsonPopulator());
    }

    //===============================================================================================================================//
    //========================= Tests on conditions populated with marin values ====================================================//


    @Test
    void shouldReturnAllConditionsOKButAge() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "12"),
                new Data<String>("aptitude", "1"),
                new Data<List<String>>("formations", Arrays.asList(
                        "P1–Appui-Navigation", "P2–Appui-Manutention/arrimage cargaison/pêche")),
                new Data<List<String>>("titres", Collections.singletonList("Certificat de sensibilisation à la sûreté (STCW10)"))
            )
        );

        // When
        List<ConditionResult> actual = evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/certificatDeMatelotPont_toPopulate.json"), marin).getDetails();

        // Then
        List<ConditionResult> expected = Arrays.asList(
                new ConditionResult("age", "age", "12", false),
                new ConditionResult("aptitude médicale", "aptitude","1", true),
                new ConditionResult("module de formation modulaire P1", "formations modulaires","[P1–Appui-Navigation, P2–Appui-Manutention/arrimage cargaison/pêche]", true),
                new ConditionResult("module de formation modulaire P2", "formations modulaires","[P1–Appui-Navigation, P2–Appui-Manutention/arrimage cargaison/pêche]", true),
                new ConditionResult("titre mainstream", "compétences en sécurité mainstream","[Certificat de sensibilisation à la sûreté (STCW10)]", true)

        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllConditionsOKButCompetenceSecurite() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "26"),
                new Data<String>("aptitude", "1"),
                new Data<List<String>>("formations", Arrays.asList(
                        "P1–Appui-Navigation", "P2–Appui-Manutention/arrimage cargaison/pêche")),
                new Data<List<String>>("titres", Collections.emptyList())
            )
        );

        // When
        List<ConditionResult> actual = evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/certificatDeMatelotPont_toPopulate.json"), marin).getDetails();

        // Then
        List<ConditionResult> expected = Arrays.asList(
                new ConditionResult("age", "age", "26", true),
                new ConditionResult("aptitude médicale", "aptitude","1", true),
                new ConditionResult("module de formation modulaire P1", "formations modulaires","[P1–Appui-Navigation, P2–Appui-Manutention/arrimage cargaison/pêche]", true),
                new ConditionResult("module de formation modulaire P2", "formations modulaires","[P1–Appui-Navigation, P2–Appui-Manutention/arrimage cargaison/pêche]", true),
                new ConditionResult("titre mainstream", "compétences en sécurité mainstream","[]", false),
                new ConditionResult("document reconnu équivalent au CFBS 2014", "équivalents pour les compétences en sécurité","[P1–Appui-Navigation, P2–Appui-Manutention/arrimage cargaison/pêche]", false),
                new ConditionResult("document reconnu équivalent au CFBS 2015", "équivalents pour les compétences en sécurité","[P1–Appui-Navigation, P2–Appui-Manutention/arrimage cargaison/pêche]", false)
        );
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllConditionsOKButFormations() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "26"),
                new Data<String>("aptitude", "1"),
                new Data<List<String>>("formations", Collections.emptyList()),
                new Data<List<String>>("titres", Arrays.asList("Certificat de sensibilisation à la sûreté (STCW10)"))
        )
        );

        // When
        List<ConditionResult> actual = evaluationService.canMarinHaveTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/certificatDeMatelotPont_toPopulate.json"), marin).getDetails();


        // Then
        List<ConditionResult> expected = Arrays.asList(
                new ConditionResult("age", "age", "26", true),
                new ConditionResult("aptitude médicale", "aptitude","1", true),
                new ConditionResult("module de formation modulaire P1", "formations modulaires","[]", false),
                new ConditionResult("module de formation modulaire P2", "formations modulaires","[]", false),
                new ConditionResult("titre reconnu équivalent à la formation modulaire 2006", "titres reconnus équivalents à la formation modulaire","[]", false),
                new ConditionResult("titre reconnu équivalent à la formation modulaire 2005", "titres reconnus équivalents à la formation modulaire","[]", false),
                new ConditionResult("titre mainstream", "compétences en sécurité mainstream","[Certificat de sensibilisation à la sûreté (STCW10)]", true)
        );

        assertEquals(expected, actual);
    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }


}