package fr.gouv.mte.capqualif.capadmin.adapters.out.mock;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.*;
import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.enums.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubConditionJpaEntityTitreToRealDataInExistingDataSourcesMapperTest {

    @Autowired
    private ExistingDataSource existingDataSource;

    private ConditionTitreToRealDataInExistingDataSourcesMapper mapper;
    LocalDate today;

    @BeforeEach
    void setUp() {
        today = LocalDate.now(); // A temporary mock until we know what reference event we should use
        mapper = new ConditionTitreToRealDataInExistingDataSourcesMapper(existingDataSource);
    }

    @Test
    void shouldReturnTheRightDataFromExistingDataSource_entryWithValue() {

        // Given
        ConditionTitre conditionTitre = new ConditionTitre(
                "Aptitude médicale",
                new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                Collections.singletonList(new Value("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, new ComparisonDate(LocalDate.now())))
        );

        // When
        CorrespondingDataInExistingDataSource realData = mapper.getInfosForSearchInExistingSource(conditionTitre);

        // Then
        CorrespondingDataInExistingDataSource expectedData = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ESCULAPE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitre.getJuridicalDesignation(),
                                "libelle",
                                DataType.STRING,
                                conditionTitre.getMainValueToCheck().getHowToCompare(),
                                new ComparisonString("Apte TF/TN"),
                                true,
                                Collections.singletonList(new ParentKey(Position.POSITION_1, "decisionMedicale"))
                        ),
                        new ValueInExistingDataSource("Apte TF/TN"), DataType.STRING
                ),
                Arrays.asList(
                        new KeyInExistingDataSource(
                                // TO DO : I don't like the juridicalName being hard coded. Replace.
                                "Date de fin de validité",
                                "dateFinDeValidite",
                                DataType.DATE,
                                Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getComparisonData()
                        )
                )
        );

        // If you need to know how equality comparison of objects works here :
        // https://www.arhohuttunen.com/junit-5-assertions/
        assertEquals(expectedData, realData);
    }

    @Test
    void shouldReturnTheRightDataFromExistingDataSource_entryWithoutValue() {

        // Given
        ConditionTitre conditionTitre = new ConditionTitre("Âge minimum",
                new Value(
                        "Âge supérieur ou égal à 16 ans",
                        ComparisonRule.GREATER_THAN)
        );

        // When
        CorrespondingDataInExistingDataSource realData = mapper.getInfosForSearchInExistingSource(conditionTitre);

        // Then
        CorrespondingDataInExistingDataSource expectedData = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ADMINISTRES,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitre.getJuridicalDesignation(),
                                "dateNaissance",
                                DataType.DATE,
                                conditionTitre.getMainValueToCheck().getHowToCompare(),
                                new ComparisonDate(LocalDate.now().minusYears(16))
                        ),
                        null,
                        DataType.DATE),
                null
        );

        // If you need to know how equality comparison of objects works here, read:
        // https://www.arhohuttunen.com/junit-5-assertions/
        assertEquals(expectedData, realData);
    }
}