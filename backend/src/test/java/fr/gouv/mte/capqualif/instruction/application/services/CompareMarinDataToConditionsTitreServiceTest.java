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
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ReferenceDate;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
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

@SpringBootTest
class CompareMarinDataToConditionsTitreServiceTest {

    @Autowired
    ExistingDataSource existingDataSource;

    @Autowired
    TimeConverter timeConverter;

    ConditionTitre conditionTitre;

    Titre titre;

    Marin marin;

    CorrespondingDataInExistingDataSource data;

    @MockBean
    private GetTitrePort getTitrePort;

    @MockBean
    private GetMarinDataPort getMarinDataPort;

    private CompareMarinDataToConditionsTitreService compareMarinDataToConditionsTitreService;

    @BeforeEach
    void setUp() {
        compareMarinDataToConditionsTitreService =
                new CompareMarinDataToConditionsTitreService(getTitrePort, getMarinDataPort, existingDataSource);

        LocalDate today = LocalDate.now(); // A temporary mock until we know what reference event we should use

        conditionTitre = new ConditionTitre(
                "Aptitude médicale",
                new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                Collections.singletonList(new Value("Date de fin de validité",
                        ComparisonRule.EQUAL_TO_OR_POSTERIOR, new ReferenceDate(LocalDate.now())))
        );

        titre = new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                Collections.singletonList(conditionTitre),
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

        data = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ESCULAPE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitre.getJuridicalDesignation(),
                                "libelle",
                                DataType.STRING,
                                conditionTitre.getMainValueToCheck().getHowToCompare(),
                                conditionTitre.getMainValueToCheck().getReferenceData(),
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
                                        .findFirst().orElse(null)).getReferenceData()
                        )
                )
        );

    }

    @Test
    void shouldReturnAllTrueComparisonResultsWhenMarinDataMeetAllConditionCriteria_stringMainCriterion_strictEqualityComparisonRule_dateAdditionalCriterion_equalToOrPosteriorComparisonRule() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), data))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Aptitude médicale", "Apte TF/TN",
                                DataType.STRING),
                        new ExtractionResult("Date de fin de validité", "1640905200000", DataType.DATE)
                ));

        // When
        List<ComparisonResult> actualResultats =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Arrays.asList(
                new ComparisonResult("Aptitude médicale", true),
                new ComparisonResult("Date de fin de validité", true)
        );
        assertEquals(expectedResults, actualResultats);
    }

    @Test
    void shouldReturnAFalseComparisonResultWhenMarinDataDoNotMeetConditionTitre_stringCondition_strictEquality() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), data))
                .thenReturn(Arrays.asList(new ExtractionResult("Aptitude médicale", "Apte TF/TN sf C/V avec " +
                        "restriction", DataType.STRING)));

        // When
        List<ComparisonResult> actualResultats =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Arrays.asList(
                new ComparisonResult(
                        "Aptitude médicale",
                        false
                )
        );

        assertEquals(expectedResults, actualResultats);
    }
}
