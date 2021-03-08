package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.*;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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

    @Autowired
    TimeConverter timeConverter;

    public CompareMarinDataToConditionsTitreService(GetTitrePort getTitrePort, GetMarinDataPort getMarinDataPort,
                                                    ExistingDataSource existingDataSource) {
        this.getTitrePort = getTitrePort;
        this.getMarinDataPort = getMarinDataPort;
        this.existingDataSource = existingDataSource;
    }

    @Override
    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
        List<ConditionTitre> conditions = getTitrePort.findTitreById(titreId).getConditions();

        List<ComparisonResult> results = new ArrayList<ComparisonResult>();

        for (ConditionTitre condition : conditions) {
            CorrespondingDataInExistingDataSource conditionRealData = existingDataSource.findByConditionValue(condition);
            List<ExtractionResult> marinMatchingData = getMarinDataPort.getMarinData(numeroDeMarin, conditionRealData);
            if (marinMatchingData.size() > 0)
                compareMarinDataToConditionCriteria(results, condition, conditionRealData, marinMatchingData);
        }
        return results;
    }

    private void compareMarinDataToConditionCriteria(List<ComparisonResult> results,
                                                     ConditionTitre condition,
                                                     CorrespondingDataInExistingDataSource conditionRealData,
                                                     List<ExtractionResult> marinMatchingData) {
        isMarinDataMeetingMainConditionCriterion(results, condition.getMainValueToCheck(), conditionRealData, marinMatchingData);
        isMarinDataMeetingAdditionalConditionCriteria(results, condition.getAdditionalValuesToCheck(), conditionRealData, marinMatchingData);
    }

    private void isMarinDataMeetingMainConditionCriterion(List<ComparisonResult> results,
                                                          Value condition,
                                                          CorrespondingDataInExistingDataSource conditionRealData,
                                                          List<ExtractionResult> marinMatchingData
                                                          ) {
        ComparisonResult comparisonResult;
        for (ExtractionResult marinData : marinMatchingData) {
            if (marinData.getKey().equals(conditionRealData.getMainWantedData().getKeyInExistingDataSource().getJuridicalName())) {
//                comparisonResult = compare()
//                results.add(comparisonResult);
            }
        }
    }

    private void isMarinDataMeetingAdditionalConditionCriteria(List<ComparisonResult> results,
                                                               List<Value> condition,
                                                               CorrespondingDataInExistingDataSource conditionRealData,
                                                               List<ExtractionResult> marinMatchingData) {
        ComparisonResult comparisonResult;
        for (KeyInExistingDataSource key : conditionRealData.getKeysOfAdditionalWantedData()) {
            for (ExtractionResult marinData : marinMatchingData) {
                if (marinData.getKey().equals(key.getJuridicalName())) {
//                    comparisonResult = compare()
//                    results.add(comparisonResult);
                }
            }
        }
    }

//    private ComparisonResult compare(ExtractionResult comparedData, EntryInExistingDataSource referenceData, ConditionTitre condition) {
//        ComparisonResult comparisonResult;
//        switch(referenceData.getDataType()) {
//            case STRING:
//                return comparisonResult = compareStrings(comparedData, referenceData, condition.get);
//            case DATE :
//                comparisonResult = compareDates(comparedData, referenceData, howToCompare);
//                return comparisonResult;
//        }
//    }

    private ComparisonResult compareStrings(ExtractionResult comparedData, EntryInExistingDataSource referenceData, ComparisonRule howToCompare) {
        ComparisonResult comparisonResult;
        if (comparedData.getValue().equals(referenceData.getValueInExistingDataSource().getContent())) {
            return comparisonResult =
                    buildComparisonResult(referenceData.getKeyInExistingDataSource().getJuridicalName(), true);
        } else {
            return comparisonResult =
                    buildComparisonResult(referenceData.getKeyInExistingDataSource().getJuridicalName(), false);
        }
    }

    private ComparisonResult compareDates(ExtractionResult comparedData, EntryInExistingDataSource referenceData, ComparisonRule howToCompare) {
        ComparisonResult comparisonResult;
        return null;
    }




    private boolean isDataDateValid(String dataDate) {
        LocalDate date = timeConverter.convertToLocalDate(dataDate); // what is Local dataDate ?

//        if(date.isAfter())
        return true;
    }

    private ComparisonResult buildComparisonResult(String key,
                                                   boolean isMarinDataMeetingConditionCriterion) {
        ComparisonResult comparisonResult;
        comparisonResult = new ComparisonResult(
                key,
                isMarinDataMeetingConditionCriterion);
        return comparisonResult;
    }
}
