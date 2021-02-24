package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.legislateur.mock.ConditionTitreToRealDataInExistingDataSourcesMapper;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompareMarinDataToConditionsTitreService implements CompareMarinDataToConditionsTitreUseCase {

    @Autowired
    GetTitrePort getTitrePort;

    @Autowired
    GetMarinDataPort getMarinDataPort;

    @Autowired
    DataChecker dataChecker;

    @Autowired
    ConditionTitreToRealDataInExistingDataSourcesMapper conditionTitreToRealDataInExistingDataSourcesMapper;

    @Override
    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
        return null;
    }

//    @Override
//    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
//        List<ConditionTitre> conditions = getConditionTitre(titreId);
//        List<ComparisonResult> results = new ArrayList<ComparisonResult>();
////        for (ConditionTitre condition : conditions) {
////            List<Entry> marinMatchingData = getMarinDataPort.getMarinData(
////                        "123",
////                        conditionTitreToRealDataInExistingDataSourcesMapper.whatExistingDataToSearchFor(condition.getValueExpressedInLegalTerms()));
////
////            // ===== TO DO : for dev logs purposes, remove later =====
////            if (marinMatchingData == null) {
////                System.out.println("No matching data found for " + condition.getJuridicalDesignation() + " = " + condition.getValueExpressedInLegalTerms());
////            } else {
////                for (Entry data : marinMatchingData) {
////                    System.out.println(data.toString());
////                }
////            }
//            // =======================================================
//
//            // Passer chaque matching marinData au dataChecker !
//
//
//
//            //      check all data (minus the main key?) validity values
//
////            List<Map> allMatchingData = dataFinder.findMatchingMarinData(condition.getExistingDataSource(),
////            numeroDeMarin);
////            boolean result = dataChecker.compareDataToCondition(allMatchingData, condition, LocalDate.now());
////            CompareResult compareResult = new CompareResult(condition.getLibelle(), result);
////            compareResults.add(compareResult);
////        }
////        return results;
//    }

//    private List<ConditionTitre> getConditionTitre(String titreId) {
//        Titre titre = getTitrePort.getTitre(titreId);
//        return titre.getConditions();
//    }


}
