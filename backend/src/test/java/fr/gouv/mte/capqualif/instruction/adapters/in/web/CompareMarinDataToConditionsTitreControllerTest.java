package fr.gouv.mte.capqualif.instruction.adapters.in.web;

import fr.gouv.mte.capqualif.instruction.application.ports.in.BipUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.services.BipService;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.mock;

@WebMvcTest(CompareMarinDataToConditionsTitreController.class)
@RunWith(MockitoJUnitRunner.class)
class CompareMarinDataToConditionsTitreControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;

    CompareMarinDataToConditionsTitreController compareMarinDataToConditionsTitreController;

    @BeforeEach
    void setup() {
        compareMarinDataToConditionsTitreController = new CompareMarinDataToConditionsTitreController(compareMarinDataToConditionsTitreUseCase);
    }

    @Test
    public void itShouldReturnAllConditionsAreMet() throws Exception {

        // Given
        List<ComparisonResult> results = new ArrayList<ComparisonResult>();
        results.add(new ComparisonResult("Age", true));

        // When
        when(compareMarinDataToConditionsTitreUseCase
                .compareMarinDataToConditionsTitre("0", "0"))
                .thenReturn(results);

        mockMvc.perform(MockMvcRequestBuilders.get("/instruction/comparaison/0/0"))
        // Then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].conditionJuridicalDesignation").value("Age"))
                // Wonder why the json is "valid" instead of "isValid" ? Take a look here : https://stackoverflow.com/q/32270422
                .andExpect(jsonPath("$[0].valid").value(true));
    }
}
