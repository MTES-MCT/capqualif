package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.instructeur.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instructeur.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instructeur.domain.Entry;
import fr.gouv.mte.capqualif.legislateur.mock.ConditionDataSourceToDataToSearchForInExistingDataSourceMapper;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompareMarinDataToConditionsTitreService implements CompareMarinDataToConditionsTitreUseCase {

    @Autowired
    GetTitlePort getTitlePort;

    @Autowired
    GetMarinDataPort getMarinDataPort;

    @Autowired
    DataChecker dataChecker;

    @Autowired
    ConditionDataSourceToDataToSearchForInExistingDataSourceMapper conditionDataSourceToDataToSearchForInExistingDataSourceMapper;

    @Override
    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
        List<ConditionTitre> conditions = getConditionTitre(titreId);
        List<ComparisonResult> results = new ArrayList<ComparisonResult>();
        for (ConditionTitre condition : conditions) {

            List<Entry> marinMatchingData = getMarinDataPort.getMarinData("123", condition.getValue(),
                    conditionDataSourceToDataToSearchForInExistingDataSourceMapper.whatExistingDataToSearchFor(condition.getExistingDataSource()));

            // ===== TO DO : for dev logs purposes, remove later =====
            if (marinMatchingData == null) {
                System.out.println("No matching data found for " + condition.getJuridicalDesignation() + " = " + condition.getValue().getContent());
            } else {
                for (Entry data : marinMatchingData) {
                    System.out.println(data.toString());
                }
            }
            // =======================================================

            // Passer chaque matching marinData au dataChecker !



            //      check all data (minus the main key?) validity values

//            List<Map> allMatchingData = dataFinder.findMatchingMarinData(condition.getExistingDataSource(),
//            numeroDeMarin);
//            boolean result = dataChecker.compareDataToCondition(allMatchingData, condition, LocalDate.now());
//            CompareResult compareResult = new CompareResult(condition.getLibelle(), result);
//            compareResults.add(compareResult);
        }
        return results;
    }

    private List<ConditionTitre> getConditionTitre(String titreId) {
        Titre titre = getTitlePort.getTitle(titreId);
        return titre.getConditions();
    }


}
