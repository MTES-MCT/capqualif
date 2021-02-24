package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataCheckerTest {

    @MockBean
    TimeConverter timeConverter;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPassIfMarinDataMatchCondition() {

        // Mock du résultat de l'appel à l'API pour la condition
//        String key = "mainKey";
//        String value = LocalDate.now().minusYears(16).toString();
//        Map<String, String> matchingData = new HashMap<>();
//        matchingData.put(key, value);
//
//        // On doit vérifier que
//        // - la mainKey est valide : condition.getValue.getContent = {mainKey=P1–Appui-Navigation}
//        ComparisonResult expected = new ComparisonResult(matchingData.keySet().toString(), )


        // - l'expirationKey est valide : today is before expirationKey

    }

    @Test
    public void testPassIfMarinDataMatchSimpleDateCondition() {
        // Create condition

//        LocalDate conditionDate = LocalDate.now().minusYears(16);
//
//        ConditionTitre conditionTitre = new ConditionTitre(
//                                "age minimum",
//                                        new Value(conditionDate.toString(), DataType.DATE),
//                                        ComparisonRule.GREATER_THAN,
//                                        ExistingDataSourceName.ADMINISTRES);
//
//        // Create macthingData
//        String key = "age minimum";
//        String valueContent = "21/09/1991";
//        Value value = new Value(valueContent, DataType.DATE);
//        Entry entry = new Entry(key, value);
//        List<Entry> marinDataList = Collections.singletonList(entry);
//
//        ComparisonResult expected = new ComparisonResult(key, true);
//        DataChecker dataChecker = new DataChecker();
//
//        Mockito.when(timeConverter.convertStringDateToLocalDate(valueContent)).thenReturn(LocalDate.of(1991, 9, 21));
//        Mockito.when(timeConverter.convertStringDateToLocalDate(conditionDate.toString())).thenReturn(LocalDate.now());
//
//        ComparisonResult tested = dataChecker.compareDataToCondition(marinDataList, conditionTitre);
//        assertEquals(expected.getConditionJuridicalDesignation(), tested.getConditionJuridicalDesignation());
//        assertEquals(expected.isValid(), tested.isValid());


        // - l'expirationKey est valide : today is before expirationKey
    }
}