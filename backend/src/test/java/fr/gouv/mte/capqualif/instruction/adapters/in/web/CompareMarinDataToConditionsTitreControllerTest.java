//package fr.gouv.mte.capqualif.instruction.adapters.in.web;
//
//import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
//import fr.gouv.mte.capqualif.instruction.domain.AllComparisonResults;
//import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.Mockito.mock;
//
//// Need some explanations about mocking annotations ?
//// Take a look here https://stackoverflow.com/a/44200907
//
//@WebMvcTest(CompareMarinDataToConditionsTitreController.class)
//class CompareMarinDataToConditionsTitreControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;
//
//    CompareMarinDataToConditionsTitreController compareMarinDataToConditionsTitreController;
//
//    @BeforeEach
//    void setup() {
//        compareMarinDataToConditionsTitreController = new CompareMarinDataToConditionsTitreController(compareMarinDataToConditionsTitreUseCase);
//    }
//
//    @Test
//    public void itShouldReturnComparaisonResultList() throws Exception {
//
//        // Given
//        List<AllComparisonResults> results = new ArrayList<AllComparisonResults>();
//        results.add(new AllComparisonResults());
//
//        // When
//        when(compareMarinDataToConditionsTitreUseCase
//                .compareMarinDataToConditionsTitre("0", "0"))
//                .thenReturn(results);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/instruction/comparaison/0/0"))
//        // Then
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].conditionJuridicalDesignation").value("Age"))
//                // Wonder why the json is "valid" instead of "isValid" ? Read here : https://stackoverflow.com/q/32270422
//                .andExpect(jsonPath("$[0].valid").value(true));
//    }
//}
