package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.EntryInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataSource;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
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
    ExistingDataSource existingDataSource;

    public CompareMarinDataToConditionsTitreService(GetTitrePort getTitrePort, GetMarinDataPort getMarinDataPort,
                                                    ExistingDataSource existingDataSource) {
        this.getTitrePort = getTitrePort;
        this.getMarinDataPort = getMarinDataPort;
        this.existingDataSource = existingDataSource;
    }

//    @Override
//    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
//        Titre titre = getTitrePort.findTitreById(titreId);
//        for (ConditionTitre condition : titre.getConditions()) {
//            compareConditionToMarinData(condition, numeroDeMarin);
//        }
//        String conditionJuridicalDesignation = "Aptitude médicale";
//        boolean isValid = true;
//        ComparisonResult result = new ComparisonResult(conditionJuridicalDesignation,
//                isValid);
//        return Collections.singletonList(result);
//    }
//
//    private void compareConditionToMarinData(ConditionTitre condition, String numeroDeMarin) {
//        DataToExtractFromExistingDataSource realConditionData = existingDataSource.findByConditionValue(condition.getValueExpressedInLegalTerms());
//        List<EntryInExistingDataSource> marinData = getMarinDataPort.getMarinData(numeroDeMarin, realConditionData);
//        ComparisonResult result = null;
//        for (EntryInExistingDataSource entry : marinData) {
//            if (realConditionData.getEntryToSearchFor().getKeyInExistingDataSource().getDataType().equals(DataType.STRING)) {
////                compareStrings(realConditionData, result, entry);
//            }
//
//        }
////        realConditionData.getEntryToSearchFor().getValue().getContent()
//
//    }
//
//    private void compareStrings(DataToExtractFromExistingDataSource realConditionData, ComparisonResult result,
//                                Entry entry) {
//        if (entry.getKey().equals(realConditionData.getEntryToSearchFor().getKeyInExistingDataSource().getName())) {
//            if (entry.getValue().equals(realConditionData.getEntryToSearchFor().getValue().getContent())) {
//                result.setValid(true);
//            } else {
//                result.setValid(false);
//            }
//        }
//    }

    @Override
    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
        List<ConditionTitre> conditions = getTitrePort.findTitreById(titreId).getConditions();
        List<ComparisonResult> results = new ArrayList<ComparisonResult>();
        for (ConditionTitre condition : conditions) {
            List<ExtractionResult> marinMatchingData = getMarinDataPort.getMarinData(
                    "123",
                    existingDataSource.findByConditionValue(condition));
        }
        return null;
    }
}
//
//            // ===== TO DO : for dev logs purposes, remove later =====
//            if (marinMatchingData == null) {
//                System.out.println("No matching data found for " + condition.getJuridicalDesignation() + " = " +
// condition.getValueExpressedInLegalTerms());
//            } else {
//                for (Entry data : marinMatchingData) {
//                    System.out.println(data.toString());
//                }
//            }
            // =======================================================

            // Passer chaque matching marinData au dataChecker !



            //      check all data (minus the main key?) validity values

//            List<Map> allMatchingData = dataFinder.findMatchingMarinData(condition.getExistingDataSource(),
//            numeroDeMarin);
//            boolean result = dataChecker.compareDataToCondition(allMatchingData, condition, LocalDate.now());
//            CompareResult compareResult = new CompareResult(condition.getLibelle(), result);
//            compareResults.add(compareResult);
//        }
//        return results;
//    }

//    private List<ConditionTitre> getConditionTitre(String titreId) {
//        Titre titre = getTitrePort.getTitre(titreId);
//        return titre.getConditions();
//    }


