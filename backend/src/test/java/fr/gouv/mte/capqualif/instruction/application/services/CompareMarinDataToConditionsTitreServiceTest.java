package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.*;
import fr.gouv.mte.capqualif.marin.domain.marin.Marin;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class CompareMarinDataToConditionsTitreServiceTest {

    @Autowired
    private ExistingDataSource existingDataSource;

    @MockBean
    private TimeConverter timeConverter;

    @MockBean
    private GetTitrePort getTitrePort;

    @MockBean
    private GetMarinDataPort getMarinDataPort;


    private Titre titre;

    private Marin marin;

    private ConditionTitre conditionTitreAptitudeMedicale;
    private ConditionTitre conditionTitreAge;
    private CorrespondingDataInExistingDataSource administresData;
    private CorrespondingDataInExistingDataSource esculapeData;

    private CompareMarinDataToConditionsTitreService compareMarinDataToConditionsTitreService;

    private LocalDate referenceDate;

    @BeforeEach
    void setUp() {
        compareMarinDataToConditionsTitreService =
                new CompareMarinDataToConditionsTitreService(getTitrePort, getMarinDataPort, existingDataSource,
                        timeConverter);

        referenceDate = LocalDate.now(); // A temporary mock until we know what reference event we should use

        conditionTitreAge = new ConditionTitre(
                "Âge minimum",
                new Value("Âge supérieur ou égal à 16 ans", ComparisonRule.EQUAL_TO_OR_GREATER_THAN));

        conditionTitreAptitudeMedicale = new ConditionTitre(
                "Aptitude médicale",
                new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                Collections.singletonList(new Value("Date de fin de validité",
                        ComparisonRule.EQUAL_TO_OR_POSTERIOR, new ComparisonDate(LocalDate.now())))
        );

        titre = new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                Arrays.asList(conditionTitreAptitudeMedicale, conditionTitreAge),
                null
        );

        marin = new Marin(
                "0",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        esculapeData = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ESCULAPE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitreAptitudeMedicale.getJuridicalDesignation(),
                                "libelle",
                                DataType.STRING,
                                conditionTitreAptitudeMedicale.getMainValueToCheck().getHowToCompare(),
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
                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getComparisonData()
                        )
                )
        );

        administresData = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ADMINISTRES,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitreAptitudeMedicale.getJuridicalDesignation(),
                                "dateNaissance", DataType.DATE,
                                conditionTitreAptitudeMedicale.getMainValueToCheck().getHowToCompare(),
                                new ComparisonDate(LocalDate.now())
                        ),
                        null,
                        DataType.DATE),
                null
        );

    }

    @Test
    void shouldReturnAllTrueComparisonResultsWhenMarinDataMeetAllConditionCriteria_stringMainCriterion_strictEqualityComparisonRule_dateAdditionalCriterion_equalToOrPosteriorComparisonRule() {
        // Given :
        // Set up made in @BeforeEach

        String aptitudeInAPI = "Apte TF/TN";
        String aptitudeComparisonReference = "Apte TF/TN";

        String dateinAPI = "1640905200000";

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), esculapeData))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Aptitude médicale", aptitudeInAPI,
                                DataType.STRING),
                        new ExtractionResult("Date de fin de validité", dateinAPI, DataType.DATE)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(2021, 12, 31);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonResult> actualResults =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Arrays.asList(
                new ComparisonResult(
                        "Aptitude médicale",
                        true,
                        buildComment(
                                new ComparisonString(aptitudeInAPI),
                                new ComparisonString(aptitudeComparisonReference),
                                conditionTitreAptitudeMedicale.getMainValueToCheck().getHowToCompare(),
                                true
                        )
                ),
                new ComparisonResult(
                        "Date de fin de validité",
                        true,
                        buildComment(
                                new ComparisonDate(convertedDateInAPI),
                                new ComparisonDate(referenceDate),
                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                true
                        )
                )
        );
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void shouldReturnAllFalseComparisonResultWhenMarinDataDoNotMeetConditionTitre_stringMainCriterion_strictEqualityComparisonRule_dateAdditionalCriterion_equalToOrPosteriorComparisonRule() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);

        String aptitudeInAPI = "Apte TF/TN sf C/V avec restriction";
        String aptitudeComparisonReference = "Apte TF/TN";

        String dateinAPI = "1584346631";

        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), esculapeData))
                .thenReturn(
                        Arrays.asList(
                                new ExtractionResult("Aptitude médicale", aptitudeInAPI, DataType.STRING),
                                new ExtractionResult("Date de fin de validité", dateinAPI, DataType.DATE)
                        )
                );

        LocalDate convertedDateInAPI = LocalDate.of(2020, 03, 16);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonResult> actualResultats =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Arrays.asList(
                new ComparisonResult(
                        "Aptitude médicale",
                        false,
                        buildComment(
                                new ComparisonString(aptitudeInAPI),
                                new ComparisonString(aptitudeComparisonReference),
                                conditionTitreAptitudeMedicale.getMainValueToCheck().getHowToCompare(),
                                false
                        )
                ),
                new ComparisonResult(
                        "Date de fin de validité",
                        false,
                        buildComment(
                                new ComparisonDate(convertedDateInAPI),
                                new ComparisonDate(referenceDate),
                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                false
                        )
                )
        );

        assertEquals(expectedResults, actualResultats);
    }

    @Test
    void shouldReturnAllTrueComparisonResultsWhenMarinDataMeetAllConditionCriteria_ageMainCriterion_equalToOrGreaterThanComparisonRule_noAdditionalCriterion() {
        // Given :
        // Set up made in @BeforeEach

        String birthDateInAPI = "25/05/1985";
        LocalDate birthDateComparisonReference = referenceDate;

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), administresData))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Âge minimum", birthDateInAPI,
                                DataType.DATE)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(1985, 05, 25);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonResult> actualResults =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(), marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Arrays.asList(
                new ComparisonResult(
                        "Âge minimum",
                        true,
                        buildComment(
                                new ComparisonDate(convertedDateInAPI),
                                new ComparisonDate(birthDateComparisonReference),
                                conditionTitreAptitudeMedicale.getMainValueToCheck().getHowToCompare(),
                                true
                        )
                )
        );
        assertEquals(expectedResults, actualResults);
    }


    private String buildComment(ComparisonData comparedData, ComparisonData comparisonData,
                                ComparisonRule comparisonRule, boolean comparisonResult) {
        return "Marin's data '" + comparedData
                + (comparisonResult ? "meets" : "does not meet ")
                + comparisonRule.toString() + " rule when compared to " + comparisonData.getValue();
    }


}
