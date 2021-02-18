package fr.gouv.mte.capqualif.instruction.adapters.in.web;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@SpringBootTest
//@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest
class RefCopyCompareMarinDataToConditionsTitreControllerTest {

    CompareMarinDataToConditionsTitreUseCase compareMarinDataToConditionsTitreUseCase;
    CompareMarinDataToConditionsTitreController compareMarinDataToConditionsTitreController;

    @BeforeEach
    void setup() {
        compareMarinDataToConditionsTitreUseCase = mock(CompareMarinDataToConditionsTitreUseCase.class);
        compareMarinDataToConditionsTitreController = new CompareMarinDataToConditionsTitreController(compareMarinDataToConditionsTitreUseCase);
    }

    @Test
    public void itShouldReturnAllConditionsAreMet() throws Exception {

        List<ComparisonResult> results = new ArrayList<ComparisonResult>();
        results.add(new ComparisonResult("Âge", true));

        when(compareMarinDataToConditionsTitreUseCase
                .compareMarinDataToConditionsTitre("0", "0"))
                .thenReturn(results);

       assertEquals(results, compareMarinDataToConditionsTitreController.compareMarinDataToTitreConditions("0", "0"));

    }
}
