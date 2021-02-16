package fr.gouv.mte.capqualif.instruction.adapters.in.web;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class CompareMarinDataToConditionsTitreControllerTest {

    @Autowired
    private CompareMarinDataToConditionsTitreController compareMarinDataToConditionsTitreController;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(compareMarinDataToConditionsTitreController);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itShouldReturnAllConditionsAreMet() throws Exception {

        // Given

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/instruction/comparaison/bip"))
                .andExpect(status().isOk())
                .andExpect(content().string("Yes"));
    }
}
