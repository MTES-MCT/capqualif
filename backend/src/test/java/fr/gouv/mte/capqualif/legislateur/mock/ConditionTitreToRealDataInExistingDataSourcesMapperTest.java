package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConditionTitreToRealDataInExistingDataSourcesMapperTest {


    @Autowired
    private ExistingDataSource existingDataSource;

    private ConditionTitreToRealDataInExistingDataSourcesMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ConditionTitreToRealDataInExistingDataSourcesMapper(existingDataSource);
    }

    @Test
    void shouldReturnTheRightDataToExtractFromExistingDataSource_entryWithValue() {

        // Given
        ConditionTitre conditionTitre = new ConditionTitre("aptitude médicale",
                "Aptitude toutes fonctions, toutes navigations",
                ComparisonRule.STRICT_EQUALITY);

        // When
        DataToExtractFromExistingDataSource realData = mapper.getInfosForSearchInExistingSource(conditionTitre);

        // Then
        DataToExtractFromExistingDataSource expectedData = new DataToExtractFromExistingDataSource(
                ExistingDataSourceName.ESCULAPE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource("libelle", DataType.STRING),
                        new Value("Apte TF/TN", DataType.STRING)
                ),
                Arrays.asList(new KeyInExistingDataSource("dateFinDeValidite", DataType.DATE))
        );

        // If you need to know how equality comparison of objects works here :
        // https://www.arhohuttunen.com/junit-5-assertions/
        assertEquals(expectedData, realData);
    }

    @Test
    void shouldReturnTheRightDataToExtractFromExistingDataSource_entryWithoutValue() {

        // Given
        ConditionTitre conditionTitre = new ConditionTitre("âge minimum",
                "Âge supérieur ou égal à 16 ans",
                ComparisonRule.GREATER_THAN);

        // When
        DataToExtractFromExistingDataSource realData = mapper.getInfosForSearchInExistingSource(conditionTitre);

        // Then
        DataToExtractFromExistingDataSource expectedData = new DataToExtractFromExistingDataSource(
                ExistingDataSourceName.ADMINISTRES,
                "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource("dateNaissance", DataType.DATE),
                        null
                ),
                null);

        // If you need to know how equality comparison of objects works here :
        // https://www.arhohuttunen.com/junit-5-assertions/
        assertEquals(expectedData, realData);
    }
}