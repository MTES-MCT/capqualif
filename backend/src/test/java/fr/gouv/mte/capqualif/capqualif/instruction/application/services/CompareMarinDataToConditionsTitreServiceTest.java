package fr.gouv.mte.capqualif.capQualif.instruction.application.services;

import fr.gouv.mte.capqualif.capQualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.capQualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capQualif.instruction.domain.ComparisonsSummary;
import fr.gouv.mte.capqualif.capQualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.mock.*;
import fr.gouv.mte.capqualif.capQualif.demande.domain.marin.Marin;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.*;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.enums.DataType;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.enums.ExistingDataSourceName;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.enums.Status;
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
    private ConditionTitre conditionTitreFormation;
    private ConditionTitre conditionTitreTitres;
    private CorrespondingDataInExistingDataSource administresData;
    private CorrespondingDataInExistingDataSource esculapeData;
    private CorrespondingDataInExistingDataSource amforeData;
    private CorrespondingDataInExistingDataSource itemData;
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
                new Value("Âge supérieur ou égal à 16 ans", ComparisonRule.EQUAL_TO_OR_ANTERIOR));

        conditionTitreAptitudeMedicale = new ConditionTitre(
                "Aptitude médicale",
                new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                Collections.singletonList(new Value("Date de fin de validité",
                        ComparisonRule.EQUAL_TO_OR_POSTERIOR, new ComparisonDate(LocalDate.now())))
        );

        conditionTitreFormation = new ConditionTitre(
                "Formation modulaire : Module P1-Appui",
                new Value("Module P1-Appui", ComparisonRule.STRICT_EQUALITY),
                Collections.singletonList(new Value("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR,
                        new ComparisonDate(LocalDate.now())))
        );

        conditionTitreTitres = new ConditionTitre("Certificat de formation de base à la sécurité (CFBS)",
                new Value("Certificat de formation de base à la sécurité (CFBS)", ComparisonRule.STRICT_EQUALITY),
                Arrays.asList(
                        new Value("Statut", ComparisonRule.STRICT_EQUALITY, Status.VALID),
                        new Value("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR,
                                new ComparisonDate(LocalDate.now()))
                )
        );

        titre = new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                Arrays.asList(conditionTitreAptitudeMedicale, conditionTitreAge, conditionTitreFormation,
                        conditionTitreTitres),
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
                                conditionTitreAge.getJuridicalDesignation(),
                                "dateNaissance", DataType.DATE,
                                conditionTitreAge.getMainValueToCheck().getHowToCompare(),
                                new ComparisonDate(LocalDate.now().minusYears(16))
                        ),
                        null,
                        DataType.DATE),
                null
        );

        amforeData = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.AMFORE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitreFormation.getJuridicalDesignation(),
                                "libelleModuleUv",
                                DataType.STRING,
                                conditionTitreFormation.getMainValueToCheck().getHowToCompare(),
                                new ComparisonString("P1–Appui-Navigation")
                        ),
                        new ValueInExistingDataSource("P1–Appui-Navigation"), DataType.STRING
                ),
                Collections.singletonList(
                        new KeyInExistingDataSource(
                                "Date de fin de validité",
                                "dateFinValidite",
                                DataType.DATE,
                                Objects.requireNonNull(conditionTitreFormation.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                Objects.requireNonNull(conditionTitreFormation.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getComparisonData()
                        )
                )
        );

        itemData = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ITEM,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitreTitres.getJuridicalDesignation(),
                                "libelle",
                                DataType.STRING,
                                conditionTitreTitres.getMainValueToCheck().getHowToCompare(),
                                new ComparisonString("Certificat de formation de base à la sécurité (STCW10)"),
                                true,
                                Collections.singletonList(
                                        new ParentKey(Position.POSITION_1, "codeBrevetMarin")
                                )
                        ),
                        new ValueInExistingDataSource(
                                "Certificat de formation de base à la sécurité (STCW10)"
                        ), DataType.STRING
                ),
                Arrays.asList(
                        new KeyInExistingDataSource(
                                "Statut",
                                "libelle",
                                DataType.STRING,
                                Objects.requireNonNull(conditionTitreTitres.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Statut".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                Objects.requireNonNull(conditionTitreTitres.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Statut".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getComparisonData(),
                                true,
                                Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                        ),
                        new KeyInExistingDataSource(
                                "Date de fin de validité",
                                "dateExpiration",
                                DataType.DATE,
                                Objects.requireNonNull(conditionTitreTitres.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getHowToCompare(),
                                Objects.requireNonNull(conditionTitreTitres.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getComparisonData()
                        )
                )
        );
    }

    /**
     * returns true comparison results when marin's aptitude médicale is valid ans is not expired
     */
    @Test
    void shouldReturnMarinMeetsAptitudeMedicaleCondition() {
        // Given :
        // Set up made in @BeforeEach

        String aptitudeInAPI = "Apte TF/TN";
        String aptitudeComparisonReference = "Apte TF/TN";

        String dateinAPI = "1640905200000";

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), esculapeData))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Aptitude médicale", aptitudeInAPI, DataType.STRING),
                        new ExtractionResult("Date de fin de validité", dateinAPI, DataType.DATE)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(2021, 12, 31);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Collections.singletonList(
                new ComparisonsSummary(
                        true,
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
                        Collections.singletonList(
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
                        )
                )
        );

        assertEquals(expected, actual);

    }


    /**
     * same as previous, but with marin's formation
     */
    @Test
    void
    shouldReturnMarinMeetsFormationMeetCondition() {
        // Given :
        // Set up made in @BeforeEach

        String formationInAPI = "P1–Appui-Navigation";
        String formationComparisonReference = "P1–Appui-Navigation";

        String dateinAPI = "2025-06-23";

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), amforeData))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Formation modulaire : Module P1-Appui", formationInAPI,
                                DataType.STRING),
                        new ExtractionResult("Date de fin de validité", dateinAPI, DataType.DATE)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(2025, 06, 23);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Arrays.asList(
                new ComparisonsSummary(
                        true,
                        new ComparisonResult(
                                "Formation modulaire : Module P1-Appui",
                                true,
                                buildComment(
                                        new ComparisonString(formationInAPI),
                                        new ComparisonString(formationComparisonReference),
                                        conditionTitreAptitudeMedicale.getMainValueToCheck().getHowToCompare(),
                                        true
                                )
                        ),
                        Collections.singletonList(
                                new ComparisonResult(
                                        "Date de fin de validité",
                                        true,
                                        buildComment(
                                                new ComparisonDate(convertedDateInAPI),
                                                new ComparisonDate(referenceDate),
                                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck()
                                                        .stream()
                                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue
                                                                .getValueExpressedInLegalTerms()))
                                                        .findFirst().orElse(null)).getHowToCompare(),
                                                true
                                        )
                                )
                        )
                )
        );
        assertEquals(expected, actual);
    }

    /**
     * same as previous, but with marin's titres
     */
    @Test
    void
    shouldReturnMarinMeetsTitreCondition() {
        // Given :
        // Set up made in @BeforeEach

        String titreInAPI = "Certificat de formation de base à la sécurité (STCW10)";
        String titreComparisonReference = "Certificat de formation de base à la sécurité (STCW10)";
        String dateInAPI = "2025-06-23";
        String statusInAPI = "Valide";
        String statusComparisonReference = "Valide";

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), itemData))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Certificat de formation de base à la sécurité (CFBS)", titreInAPI,
                                DataType.STRING),
                        new ExtractionResult("Date de fin de validité", dateInAPI, DataType.DATE),
                        new ExtractionResult("Statut", statusInAPI, DataType.STRING)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(2025, 06, 23);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Arrays.asList(
                new ComparisonsSummary(
                        true,
                        new ComparisonResult(
                                "Certificat de formation de base à la sécurité (CFBS)",
                                true,
                                buildComment(
                                        new ComparisonString(titreInAPI),
                                        new ComparisonString(titreComparisonReference),
                                        conditionTitreTitres.getMainValueToCheck().getHowToCompare(),
                                        true
                                )
                        ),
                        Arrays.asList(
                                new ComparisonResult(
                                        "Statut",
                                        true,
                                        buildComment(
                                                new ComparisonString(statusInAPI),
                                                new ComparisonString(statusComparisonReference),
                                                Objects.requireNonNull(conditionTitreTitres.getAdditionalValuesToCheck().stream()
                                                        .filter(additionalValue -> "Statut".equals(additionalValue
                                                                .getValueExpressedInLegalTerms()))
                                                        .findFirst().orElse(null)).getHowToCompare(),
                                                true
                                        )
                                ),
                                new ComparisonResult(
                                        "Date de fin de validité",
                                        true,
                                        buildComment(
                                                new ComparisonDate(convertedDateInAPI),
                                                new ComparisonDate(referenceDate),
                                                Objects.requireNonNull(conditionTitreTitres.getAdditionalValuesToCheck().stream()
                                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue
                                                                .getValueExpressedInLegalTerms()))
                                                        .findFirst().orElse(null)).getHowToCompare(),
                                                true
                                        )
                                )
                        )
                )
        );
        assertEquals(expected, actual);
    }

    /**
     * returns false comparison results if marin's aptitude médicale is not valid and is expired
     */
    @Test
    void
    shouldReturnMarinFailsConditionWhenMarinAptitudeMedicaleIsNotTheExpectedOne() {
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
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Collections.singletonList(
                new ComparisonsSummary(
                        false,
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
                        Collections.singletonList(
                                new ComparisonResult(
                                        "Date de fin de validité",
                                        false,
                                        buildComment(
                                                new ComparisonDate(convertedDateInAPI),
                                                new ComparisonDate(referenceDate),
                                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck()
                                                        .stream()
                                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue
                                                                .getValueExpressedInLegalTerms()))
                                                        .findFirst().orElse(null)).getHowToCompare(),
                                                false
                                        )
                                )
                        )
                )
        );

        assertEquals(expected, actual);
    }

    /**
     * returns false comparison results if marin's aptitude médicale is null and is expired
     */
    @Test
    void
    shouldReturnMarinFailsConditionWhenMarinAptitudeMedicaleIsNull() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);

        String aptitudeInAPI = null;
        String aptitudeComparisonReference = "Apte TF/TN";

        String dateInAPI = "1584346631";

        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), esculapeData))
                .thenReturn(
                        Arrays.asList(
                                new ExtractionResult("Aptitude médicale", aptitudeInAPI, DataType.STRING),
                                new ExtractionResult("Date de fin de validité", dateInAPI, DataType.DATE)
                        )
                );

        LocalDate convertedDateInAPI = LocalDate.of(2020, 03, 16);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Arrays.asList(
                new ComparisonsSummary(
                        false,
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
                        Collections.singletonList(
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
                        )
                )
        );

        assertEquals(expected, actual);
    }

    /**
     * returns
     * true comparison result if marin's aptitude médicale is ok
     * false comparison result if marin's aptitude médicale data is expired
     */
    @Test
    void
    shouldReturnMarinFailsConditionWhenMarinAptitudeMedicaleIsExpired() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);

        String aptitudeInAPI = "Apte TF/TN";
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
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Arrays.asList(
                new ComparisonsSummary(
                        false,
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
                        Collections.singletonList(
                                new ComparisonResult(
                                        "Date de fin de validité",
                                        false,
                                        buildComment(
                                                new ComparisonDate(convertedDateInAPI),
                                                new ComparisonDate(referenceDate),
                                                Objects.requireNonNull(conditionTitreAptitudeMedicale.getAdditionalValuesToCheck()
                                                        .stream()
                                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue
                                                                .getValueExpressedInLegalTerms()))
                                                        .findFirst().orElse(null)).getHowToCompare(),
                                                false
                                        )
                                )
                        )
                )
        );

        assertEquals(expected, actual);
    }

    /**
     * returns a true comparison result if marin is 16 or older
     */
    @Test
    void
    shouldReturnMarinMeetsAgeCondition() {
        // Given :
        // Set up made in @BeforeEach

        String birthDateInAPI = "25/05/1985";
        LocalDate birthDateComparisonReference = referenceDate.minusYears(16);

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), administresData))
                .thenReturn(Collections.singletonList(
                        new ExtractionResult("Âge minimum", birthDateInAPI, DataType.DATE)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(1985, 05, 25);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Collections.singletonList(
                new ComparisonsSummary(
                        true,
                        new ComparisonResult(
                                "Âge minimum",
                                true,
                                buildComment(
                                        new ComparisonDate(convertedDateInAPI),
                                        new ComparisonDate(birthDateComparisonReference),
                                        conditionTitreAge.getMainValueToCheck().getHowToCompare(),
                                        true
                                )
                        ),
                        null
                )
        );
        assertEquals(expected, actual);
    }

    /**
     * returns a false comparison result if marin is younger than 16
     */
    @Test
    void
    shouldReturnMarinFailsAgeCondition() {
        // Given :
        // Set up made in @BeforeEach

        String birthDateInAPI = "25/05/2008";
        LocalDate birthDateComparisonReference = referenceDate.minusYears(16);

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), administresData))
                .thenReturn(Arrays.asList(
                        new ExtractionResult("Âge minimum", birthDateInAPI, DataType.DATE)
                ));

        LocalDate convertedDateInAPI = LocalDate.of(2008, 05, 25);
        Mockito.when(timeConverter.convertToLocalDate(anyString())).thenReturn(convertedDateInAPI);

        // When
        List<ComparisonsSummary> actual =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonsSummary> expected = Arrays.asList(
                new ComparisonsSummary(
                        false,
                        new ComparisonResult(
                                "Âge minimum",
                                false,
                                buildComment(
                                        new ComparisonDate(convertedDateInAPI),
                                        new ComparisonDate(birthDateComparisonReference),
                                        conditionTitreAge.getMainValueToCheck().getHowToCompare(),
                                        false
                                )
                        ),
                        null
                )
        );
        assertEquals(expected, actual);
    }


    private String buildComment(ComparisonData comparedData, ComparisonData comparisonData,
                                ComparisonRule comparisonRule, boolean comparisonResult) {
        return "Marin's data '"
                + comparedData.getValue()
                + "' "
                + (comparisonResult ? "meets " : "does not meet ")
                + comparisonRule.toString() + " rule when compared to " + comparisonData.getValue();
    }

};
