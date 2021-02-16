package fr.gouv.mte.capqualif.instruction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testName() throws Exception {
        // arrange

        // act

        // https://www.baeldung.com/spring-resttemplate-json-list#3-resttemplate-with-user-list-and-parameterizedtypereference
//        ParameterizedTypeReference<List<ComparisonResult>> comparisonResults = new ParameterizedTypeReference<List<ComparisonResult>>() {};
//        ResponseEntity<List<ComparisonResult>> response = restTemplate.exchange("/instruction/comparaison/1/123",
//                HttpMethod.GET, null, comparisonResults);
//
//        // assert
//        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(response.getBody()).isEqualTo("[{}]");
    }

    @Test
    public void itShouldReturnAllConditionsAreMet() throws Exception {

        // Given

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/instruction/comparaison/1/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].conditionJuridicalName").value("Âge"))
                .andExpect(jsonPath("$[0].validity").value(true))
                .andExpect(jsonPath("$[1].conditionJuridicalName").value("Aptitude médicale"))
                .andExpect(jsonPath("$[1].validity").value(true))
                .andExpect(jsonPath("$[2].conditionJuridicalName").value("Formation de base à la sécurité"))
                .andExpect(jsonPath("$[2].validity").value(true))
                .andExpect(jsonPath("$[3].conditionJuridicalName").value("Formation pour le certificat de matelot pont, Module P1-Appui"))
                .andExpect(jsonPath("$[3].validity").value(true))
                .andExpect(jsonPath("$[4].conditionJuridicalName").value("Formation pour le certificat de matelot pont, Module P2–Appui"))
                .andExpect(jsonPath("$[4].validity").value(true))
                .andExpect(jsonPath("$[5].conditionJuridicalName").value("Formation pour le certificat de matelot pont, Module P3–Appui"))
                .andExpect(jsonPath("$[5].validity").value(true))
                .andExpect(jsonPath("$[6].conditionJuridicalName").value("Formation pour le certificat de matelot pont, Module NP–Appui"))
                .andExpect(jsonPath("$[6].validity").value(true));

        // 1. Récupérer le mock d'un titre
//        String titreId = "1";
//        titresApiMock.findTitreById(titreId);
//
//        Titre titre = titresApiMock.findTitreById(titreId);
//
//        // 2. Donner les json du marin
//        String numeroDeMarin = "123";
//
//        // 3. Avoir une liste de ComparisonResult avec CompareResult(condition.getLibelle(), result de dataChecker)
//
//        // 4. Résultat espéré
//        List<ComparisonResult> expectedResult = new ArrayList<>();
//        for (ConditionTitre condition : titre.getConditions()) {
//            expectedResult.add(new ComparisonResult(condition.getJuridicalDesignation(), true));
//        }
//
//        // 5. Résultat réel
//        CompareMarinDataToConditionsTitreService service = new CompareMarinDataToConditionsTitreService();
//        List<ComparisonResult> testedResult = service.compareMarinDataToConditionsTitre(titreId, numeroDeMarin);
//        assertEquals(expectedResult, testedResult);
////        assertEquals("123", "12");

    }

}