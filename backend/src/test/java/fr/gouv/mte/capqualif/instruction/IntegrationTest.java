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

        mockMvc.perform(MockMvcRequestBuilders.get("/instruction/comparaison/1/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].conditionJuridicalDesignation").value("Âge minimum"))
                .andExpect(jsonPath("$[0].valid").value(true))
                .andExpect(jsonPath("$[1].conditionJuridicalDesignation").value("Aptitude médicale"))
                .andExpect(jsonPath("$[1].valid").value(true))
                .andExpect(jsonPath("$[2].conditionJuridicalDesignation").value("Formation modulaire : Module P1-Appui"))
                .andExpect(jsonPath("$[2].valid").value(true))
                .andExpect(jsonPath("$[3].conditionJuridicalDesignation").value("Formation modulaire : Module P2-Appui"))
                .andExpect(jsonPath("$[3].valid").value(true))
                .andExpect(jsonPath("$[4].conditionJuridicalDesignation").value("Formation modulaire : Module P3-Appui"))
                .andExpect(jsonPath("$[4].valid").value(true))
                .andExpect(jsonPath("$[5].conditionJuridicalDesignation").value("Formation modulaire : Module NP-Appui"))
                .andExpect(jsonPath("$[5].valid").value(true))
                .andExpect(jsonPath("$[6].conditionJuridicalDesignation").value("Certificat de formation de base à la sécurité (CFBS)"))
                .andExpect(jsonPath("$[6].valid").value(true));

    }

}