package fr.gouv.mte.capqualif.domain.capQualif.instruction;

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
    public void itShouldReturnAllConditionsAreMet() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/instruction/comparaison/1/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].conditionMet").value(true))
                .andExpect(jsonPath("$[0].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Âge minimum"))
                .andExpect(jsonPath("$[0].comparisonResultForMainCriterion.valid").value(true))

                .andExpect(jsonPath("$[1].conditionMet").value(true))
                .andExpect(jsonPath("$[1].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Aptitude médicale"))
                .andExpect(jsonPath("$[1].comparisonResultForMainCriterion.valid").value(true))
                .andExpect(jsonPath("$[1].comparisonResultsForAdditionalCriteria[0].conditionJuridicalDesignation").value("Date de fin de validité"))
                .andExpect(jsonPath("$[1].comparisonResultsForAdditionalCriteria[0].valid").value(true))

                .andExpect(jsonPath("$[2].conditionMet").value(true))
                .andExpect(jsonPath("$[2].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Formation modulaire : Module P1-Appui"))
                .andExpect(jsonPath("$[2].comparisonResultForMainCriterion.valid").value(true))
                .andExpect(jsonPath("$[2].comparisonResultsForAdditionalCriteria[0].conditionJuridicalDesignation").value("Date de fin de validité"))
                .andExpect(jsonPath("$[2].comparisonResultsForAdditionalCriteria[0].valid").value(true))

                .andExpect(jsonPath("$[3].conditionMet").value(true))
                .andExpect(jsonPath("$[3].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Formation modulaire : Module P2-Appui"))
                .andExpect(jsonPath("$[3].comparisonResultForMainCriterion.valid").value(true))
                .andExpect(jsonPath("$[3].comparisonResultsForAdditionalCriteria[0].conditionJuridicalDesignation").value("Date de fin de validité"))
                .andExpect(jsonPath("$[3].comparisonResultsForAdditionalCriteria[0].valid").value(true))

                .andExpect(jsonPath("$[4].conditionMet").value(true))
                .andExpect(jsonPath("$[4].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Formation modulaire : Module P3-Appui"))
                .andExpect(jsonPath("$[4].comparisonResultForMainCriterion.valid").value(true))
                .andExpect(jsonPath("$[4].comparisonResultsForAdditionalCriteria[0].conditionJuridicalDesignation").value("Date de fin de validité"))
                .andExpect(jsonPath("$[4].comparisonResultsForAdditionalCriteria[0].valid").value(true))

                .andExpect(jsonPath("$[5].conditionMet").value(true))
                .andExpect(jsonPath("$[5].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Formation modulaire : Module NP-Appui"))
                .andExpect(jsonPath("$[5].comparisonResultForMainCriterion.valid").value(true))
                .andExpect(jsonPath("$[5].comparisonResultsForAdditionalCriteria[0].conditionJuridicalDesignation").value("Date de fin de validité"))
                .andExpect(jsonPath("$[5].comparisonResultsForAdditionalCriteria[0].valid").value(true))

                .andExpect(jsonPath("$[6].conditionMet").value(true))
                .andExpect(jsonPath("$[6].comparisonResultForMainCriterion.conditionJuridicalDesignation").value("Certificat de formation de base à la sécurité (CFBS)"))
                .andExpect(jsonPath("$[6].comparisonResultForMainCriterion.valid").value(true))
                .andExpect(jsonPath("$[6].comparisonResultsForAdditionalCriteria[0].conditionJuridicalDesignation").value("Statut"))
                .andExpect(jsonPath("$[6].comparisonResultsForAdditionalCriteria[0].valid").value(true))
                .andExpect(jsonPath("$[6].comparisonResultsForAdditionalCriteria[1].conditionJuridicalDesignation").value("Date de fin de validité"))
                .andExpect(jsonPath("$[6].comparisonResultsForAdditionalCriteria[1].valid").value(true));
    }
}