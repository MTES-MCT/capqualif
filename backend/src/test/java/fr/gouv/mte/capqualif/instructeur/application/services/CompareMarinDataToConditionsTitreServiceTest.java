package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.instructeur.domain.ComparisonResult;
import fr.gouv.mte.capqualif.titre.adapters.out.api.GetTitleApiAdapter;
import fr.gouv.mte.capqualif.titre.adapters.out.api.mocks.TitresApiMock;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompareMarinDataToConditionsTitreServiceTest {

    @Autowired
    TitresApiMock titresApiMock;

    @MockBean
    GetTitleApiAdapter getTitlePort;

    @Before
    public void setUp() throws Exception {
//        GetTitlePort getTitlePort = new GetTitleApiAdapter();
//        titresApiMock = new TitresApiMock();
//        titresApiMock.setGetTitlePort(getTitlePort);
    }

    @Test
    public void itShouldDetermineThatMarinMatchesAllConditions() {
        // 1. Récupérer le mock d'un titre
        String titreId = "1";
        titresApiMock.findTitleById(titreId);

        Titre titre = titresApiMock.findTitleById(titreId);

        // 2. Donner les json du marin
        String numeroDeMarin = "123";

        // 3. Avoir une liste de ComparisonResult avec CompareResult(condition.getLibelle(), result de dataChecker)

        // 4. Résultat espéré
        List<ComparisonResult> expectedResult = new ArrayList<>();
        for (ConditionTitre condition : titre.getConditions()) {
            expectedResult.add(new ComparisonResult(condition.getJuridicalDesignation(), true));
        }

        // 5. Résultat réel
        CompareMarinDataToConditionsTitreService service = new CompareMarinDataToConditionsTitreService();
        List<ComparisonResult> testedResult = service.compareMarinDataToConditionsTitre(titreId, numeroDeMarin);
        assertEquals(expectedResult, testedResult);
//        assertEquals("123", "12");

    }

}