package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CompareMarinDataToConditionsTitreServiceTest {

    private CompareMarinDataToConditionsTitreService compareMarinDataToConditionsTitreService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnAPositiveComparisonResultWhenMarinDataMeetTitreCondition_StringCondition() {
        // Given
//        ConditionTitre conditionTitre = new ConditionTitre("Aptitude médicale", new Value("Apte"), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.ESCULAPE);
//        Titre titre = new Titre("0", "Certificat de Matelot Pont", )


        // When

        // Then
        List<ComparisonResult> expectedResults = new ArrayList<ComparisonResult>();
        expectedResults.add(new ComparisonResult("Aptitude médicale", true));

//        compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre("0", )



    }
}