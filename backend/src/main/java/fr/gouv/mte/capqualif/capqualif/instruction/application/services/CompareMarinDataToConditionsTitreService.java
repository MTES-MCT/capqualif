package fr.gouv.mte.capqualif.capqualif.instruction.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import fr.gouv.mte.capqualif.capqualif.evaluator.application.services.EvaluationService;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.InstructionMapper;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.*;
//import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ComparisonResult;
import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out.GetMarinDataPort;
//import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ComparisonsSummary;
//import fr.gouv.mte.capqualif.capqualif.instruction.domain.archive.ExtractionResult;
//import fr.gouv.mte.capqualif.capadmin.adapters.out.mock.EntryInExistingDataSource;
//import fr.gouv.mte.capqualif.capadmin.adapters.out.mock.KeyInExistingDataSource;
//import fr.gouv.mte.capqualif.shared.TimeConverter;
//import fr.gouv.mte.capqualif.capadmin.titreTemp.application.ports.out.GetTitrePort;
//import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.*;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData.MarinData;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData.MarinDataPurified;
import fr.gouv.mte.capqualif.shared.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CompareMarinDataToConditionsTitreService implements CompareMarinDataToConditionsTitreUseCase {

    @Autowired
    GetMarinDataPort getMarinDataPort;

    @Autowired
    EvaluationService evaluationService;

    @Autowired
    InstructionMapper instructionMapper;

    @Autowired
    JsonConverter jsonConverter;

    public CompareMarinDataToConditionsTitreService(GetMarinDataPort getMarinDataPort) {
        this.getMarinDataPort = getMarinDataPort;
    }

    public void compareMarinDataToConditionsTitre(String marinId) {
        Map<String, List<MarinData>> allMarinData = getMarinDataPort.getAllMarinData(marinId);
        System.out.println("allMarinData: " + allMarinData);
        List<Data> data = new ArrayList<>();

        Map<String, List<MarinDataPurified>> allMarinDataPurified = new HashMap<>();

        for (Map.Entry<String, List<MarinData>> entry : allMarinData.entrySet()) {
            /**
             * TODO: check MarinData validity before building Marin
             */

            /**
             * TODO: simplify
             */
            List<MarinDataPurified> purifiedData = new ArrayList<>();
            List<MarinData> mds = entry.getValue();
            for (MarinData md : mds) {
                purifiedData.add(new MarinDataPurified(md.getValue()));
            }
            allMarinDataPurified.put(entry.getKey(), purifiedData);
        }

        for (Map.Entry<String, List<MarinDataPurified>> entry : allMarinDataPurified.entrySet()) {
            if (entry.getValue().size() == 1) {
                MarinDataPurified stripped = entry.getValue().get(0);
                data.add(new Data(entry.getKey(), stripped.getValue()));
            } else {
                List<String> sl = new ArrayList<>();
                List<MarinDataPurified> list = entry.getValue();
                for (MarinDataPurified marinDataPurified : list) {
                    sl.add(marinDataPurified.getValue());
                }
                data.add(new Data(entry.getKey(), sl));
            }
        }

        Marin marin = new Marin(data);
        System.out.println("marin " + marin);
        try {
            System.out.println("eval " + evaluationService.canMarinHaveTitre(jsonConverter.jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json"), marin).getDetails());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private boolean checkValidity(MarinData data) {
//
//    }

//    private boolean compareDates(LocalDate comparedDate, ComparisonDate referenceDate, ComparisonRule comparisonRule) {
//        LocalDate refDate = referenceDate.getData();
//        boolean result = false;
//        switch (comparisonRule) {
//            case EQUAL_TO_OR_POSTERIOR:
//                if (comparedDate.isAfter(refDate) || comparedDate.isEqual(refDate)) {
//                    result = true;
//                }
//                break;
//            case EQUAL_TO_OR_ANTERIOR:
//                if (comparedDate.isBefore(refDate) || comparedDate.isEqual(refDate)) {
//                    result = true;
//                }
//                break;
//            case STRICTLY_ANTERIOR:
//                if (comparedDate.isBefore(refDate)) {
//                    result = true;
//                }
//                break;
//            case STRICTLY_POSTERIOR:
//                if (comparedDate.isAfter(refDate)) {
//                    result = true;
//                }
//                break;
//            default:
//                return false;
//        }
//        return result;
//    }

//    @Autowired
//    GetTitrePort getTitrePort;
//
//    @Autowired
//    GetMarinDataPort getMarinDataPort;
//
//    @Autowired
//    ExistingDataSource existingDataSource;
//
//    @Autowired
//    TimeConverter timeConverter;
//
//    public CompareMarinDataToConditionsTitreService(GetTitrePort getTitrePort, GetMarinDataPort getMarinDataPort,
//                                                    ExistingDataSource existingDataSource,
//                                                    TimeConverter timeConverter) {
//        this.getTitrePort = getTitrePort;
//        this.getMarinDataPort = getMarinDataPort;
//        this.existingDataSource = existingDataSource;
//        this.timeConverter = timeConverter;
//    }
//
//    @Override
//    public List<ComparisonsSummary> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
//
//        List<ConditionTitre> conditions = getTitrePort.findTitreById(titreId).getConditions();
//        List<ComparisonsSummary> allComparisonsSummaries = new ArrayList<>();
//
//        for (ConditionTitre condition : conditions) {
//            CorrespondingDataInExistingDataSource conditionRealData =
//                    existingDataSource.findByConditionValue(condition);
//
//            List<ExtractionResult> marinDataThatMatchCondition = getMarinDataPort.getMarinData(numeroDeMarin,
//                    conditionRealData);
//
//            ComparisonsSummary comparisonsSummary = new ComparisonsSummary(false, null, null);
//
//            if (marinDataThatMatchCondition.size() > 0) {
//                compareMarinDataToConditionCriteria(comparisonsSummary, condition, conditionRealData, marinDataThatMatchCondition);
//                allComparisonsSummaries.add(comparisonsSummary);
//            }
//        }
//        return allComparisonsSummaries;
//    }
//
//    private void compareMarinDataToConditionCriteria(ComparisonsSummary comparisonsSummary,
//                                                     ConditionTitre condition,
//                                                     CorrespondingDataInExistingDataSource conditionRealData,
//                                                     List<ExtractionResult> marinMatchingData) {
//        if (conditionRealData.getMainWantedData() != null)
//            doesMarinMeetMainCriterion(comparisonsSummary, conditionRealData.getMainWantedData(), marinMatchingData);
//        if (conditionRealData.getKeysOfAdditionalWantedData() != null)
//            doesMarinMeetAdditionalCriteria(comparisonsSummary, conditionRealData.getKeysOfAdditionalWantedData(), marinMatchingData);
//        comparisonsSummary.setConditionMet(isConditionMet(comparisonsSummary));
//    }
//
//    private boolean isConditionMet(ComparisonsSummary comparisonsSummary) {
//        return comparisonsSummary.getComparisonResultForMainCriterion().isValid() && additionalCriteriaAreMet(comparisonsSummary);
//    }
//
//    private boolean additionalCriteriaAreMet(ComparisonsSummary comparisonsSummary) {
//        if (comparisonsSummary.getComparisonResultsForAdditionalCriteria() != null)
//            for (ComparisonResult comparisonResult :
//                    comparisonsSummary.getComparisonResultsForAdditionalCriteria()) {
//                if (!comparisonResult.isValid())
//                    return false;
//            }
//        return true;
//    }
//
//    private void doesMarinMeetMainCriterion(ComparisonsSummary comparisonsSummary,
//                                            EntryInExistingDataSource conditionData,
//                                            List<ExtractionResult> marinMatchingData) {
//        for (ExtractionResult marinData : marinMatchingData) {
//            if (marinDataKeyEqualsReferenceKey(marinData, conditionData.getKeyInExistingDataSource())) {
//                compareForMainCriterion(comparisonsSummary, conditionData, marinData);
//            }
//        }
//    }
//
//    private void compareForMainCriterion(ComparisonsSummary comparisonsSummary,
//                                         EntryInExistingDataSource conditionData, ExtractionResult marinData) {
//        ComparisonResult comparisonResult;
//        switch (conditionData.getKeyInExistingDataSource().getDataType()) {
//            case STRING:
//                boolean stringComparisonResult =
//                        compareStrings(
//                                marinData.getValue(),
//                                new ComparisonString(conditionData.getValueInExistingDataSource().getContent()),
//                                conditionData.getKeyInExistingDataSource().getComparisonRule()
//                        );
//                comparisonResult =
//                        buildComparisonResult(conditionData.getKeyInExistingDataSource().getJuridicalName(),
//                                stringComparisonResult,
//                                buildComment(
//                                        new ComparisonString(marinData.getValue()),
//                                        new ComparisonString(conditionData.getValueInExistingDataSource().getContent()),
//                                        conditionData.getKeyInExistingDataSource().getComparisonRule(),
//                                        stringComparisonResult
//                                )
//                        );
//                comparisonsSummary.setComparisonResultForMainCriterion(comparisonResult);
//                break;
//            case DATE:
//                boolean dateComparisonResult = compareDates(
//                        timeConverter.convertToLocalDate(marinData.getValue()),
//                        (ComparisonDate) conditionData.getKeyInExistingDataSource().getComparisonReference(), //
//                        // TO-DO : rewrite better
//                        conditionData.getKeyInExistingDataSource().getComparisonRule()
//                );
//                comparisonResult =
//                        buildComparisonResult(conditionData.getKeyInExistingDataSource().getJuridicalName(),
//                                dateComparisonResult,
//                                buildComment(
//                                        new ComparisonDate(timeConverter.convertToLocalDate(marinData.getValue())),
//                                        conditionData.getKeyInExistingDataSource().getComparisonReference(),
//                                        conditionData.getKeyInExistingDataSource().getComparisonRule(),
//                                        dateComparisonResult
//                                ));
//                comparisonsSummary.setComparisonResultForMainCriterion(comparisonResult);
//                break;
//        }
//    }
//
//    private void doesMarinMeetAdditionalCriteria(ComparisonsSummary comparisonsSummary,
//                                                 List<KeyInExistingDataSource> additionalData,
//                                                 List<ExtractionResult> marinMatchingData) {
//        List<ComparisonResult> additionalCriteriaComparisonResults = new ArrayList<>();
//        for (KeyInExistingDataSource key : additionalData) {
//            for (ExtractionResult marinData : marinMatchingData) {
//                if (marinDataKeyEqualsReferenceKey(marinData, key)) {
//                    compareForAdditionalCriterion(additionalCriteriaComparisonResults, key, marinData);
//                }
//            }
//        }
//        comparisonsSummary.setComparisonResultsForAdditionalCriteria(additionalCriteriaComparisonResults);
//    }
//
//    private void compareForAdditionalCriterion(List<ComparisonResult> additionalCriteriaComparisonResults,
//                                               KeyInExistingDataSource key, ExtractionResult marinData) {
//        ComparisonResult comparisonResult;
//        switch (key.getDataType()) {
//            case STRING:
//                boolean stringComparisonResult = compareStrings(
//                        marinData.getValue(),
//                        new ComparisonString(key.getComparisonReference().getValue()),
//                        key.getComparisonRule()
//                );
//                comparisonResult =
//                        buildComparisonResult(key.getJuridicalName(), stringComparisonResult,
//                                buildComment(new ComparisonString(marinData.getValue()), key.getComparisonReference(), key.getComparisonRule(), stringComparisonResult));
//                additionalCriteriaComparisonResults.add(comparisonResult);
//                break;
//            case DATE:
//                boolean dateComparisonResult = compareDates(
//                        timeConverter.convertToLocalDate(marinData.getValue()),
//                        (ComparisonDate) key.getComparisonReference(),
//                        key.getComparisonRule()
//                );
//                comparisonResult =
//                        buildComparisonResult(
//                                key.getJuridicalName(),
//                                dateComparisonResult,
//                                buildComment(
//                                        new ComparisonDate(
//                                                timeConverter.convertToLocalDate(marinData.getValue())),
//                                        key.getComparisonReference(),
//                                        key.getComparisonRule(),
//                                        dateComparisonResult
//                                )
//                        );
//                additionalCriteriaComparisonResults.add(comparisonResult);
//                break;
//        }
//    }
//
//    private boolean marinDataKeyEqualsReferenceKey(ExtractionResult marinData,
//                                                   KeyInExistingDataSource keyInExistingDataSource) {
//        return marinData.getKey().equals(keyInExistingDataSource.getJuridicalName());
//    }
//
//    private boolean compareStrings(String comparedData, ComparisonString referenceString,
//                                   ComparisonRule comparisonRule) {
//        // TO DO : add more cases if needed
//        boolean result = false;
//        switch (comparisonRule) {
//            case STRICT_EQUALITY:
//                if (comparedData.equals(referenceString.getReference())) {
//                    result = true;
//                }
//                break;
//            default:
//                return false;
//        }
//        return result;
//    }
//
//    private boolean compareDates(LocalDate comparedDate, ComparisonDate referenceDate, ComparisonRule comparisonRule) {
//        LocalDate refDate = referenceDate.getData();
//        boolean result = false;
//        switch (comparisonRule) {
//            case EQUAL_TO_OR_POSTERIOR:
//                if (comparedDate.isAfter(refDate) || comparedDate.isEqual(refDate)) {
//                    result = true;
//                }
//                break;
//            case EQUAL_TO_OR_ANTERIOR:
//                if (comparedDate.isBefore(refDate) || comparedDate.isEqual(refDate)) {
//                    result = true;
//                }
//                break;
//            case STRICTLY_ANTERIOR:
//                if (comparedDate.isBefore(refDate)) {
//                    result = true;
//                }
//                break;
//            case STRICTLY_POSTERIOR:
//                if (comparedDate.isAfter(refDate)) {
//                    result = true;
//                }
//                break;
//            default:
//                return false;
//        }
//        return result;
//    }
//
//    private ComparisonResult buildComparisonResult(String key, boolean isMarinDataMeetingConditionCriterion, String comment) {
//        return new ComparisonResult(key, isMarinDataMeetingConditionCriterion, comment);
//    }
//
//    private String buildComment(ComparisonData comparedData, ComparisonData comparisonData,
//                                ComparisonRule comparisonRule, boolean comparisonResult) {
//        return "Marin's data '"
//                + comparedData.getValue()
//                + "' "
//                + (comparisonResult ? "meets " : "does not meet ")
//                + comparisonRule.toString() + " rule when compared to " + comparisonData.getValue();
//    }

}
