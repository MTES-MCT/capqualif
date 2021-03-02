package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.legislateur.mock.EntryInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.KeyInExistingDataSource;
import fr.gouv.mte.capqualif.marin.domain.marin.Marin;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompareMarinDataToConditionsTitreServiceTest {

    @MockBean
    private GetTitrePort getTitrePort;

    @MockBean
    private GetMarinDataPort getMarinDataPort;

    @Autowired
    ExistingDataSource existingDataSource;

    private CompareMarinDataToConditionsTitreService compareMarinDataToConditionsTitreService;

    @BeforeEach
    void setUp() {
        compareMarinDataToConditionsTitreService =
                new CompareMarinDataToConditionsTitreService(getTitrePort, getMarinDataPort, existingDataSource);
    }

    @Test
    void shouldReturnAPositiveComparisonResultWhenMarinDataMeetConditionTitre_stringCondition() {
        // Given
        ConditionTitre conditionTitre = new ConditionTitre("Aptitude médicale",
                "Aptitude toutes fonctions, toutes navigations",
                ComparisonRule.STRICT_EQUALITY);

        Titre titre = new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                Collections.singletonList(conditionTitre),
                null);

        Marin marin = new Marin(
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

        // When

        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), null))
                .thenReturn(Arrays.asList(new EntryInExistingDataSource(new KeyInExistingDataSource("libelle"), new Value("Apte TF/TN"), DataType.STRING)));

        List<ComparisonResult> realResults =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(),
                        marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Collections.singletonList(new ComparisonResult("Aptitude médicale",
                true));

        assertEquals(expectedResults, realResults);

    }
}
