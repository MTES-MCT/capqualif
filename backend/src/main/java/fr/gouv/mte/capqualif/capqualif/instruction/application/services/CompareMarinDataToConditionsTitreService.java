package fr.gouv.mte.capqualif.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSource;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.DataSources;
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
import fr.gouv.mte.capqualif.capqualif.instruction.domain.JuridicalDesignations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class CompareMarinDataToConditionsTitreService implements CompareMarinDataToConditionsTitreUseCase {

    @Autowired
    GetMarinDataPort getMarinDataPort;

    public CompareMarinDataToConditionsTitreService(GetMarinDataPort getMarinDataPort) {
        this.getMarinDataPort = getMarinDataPort;
    }

    DataSources DATA_SOURCES_MOCK = new DataSources(Arrays.asList(
            new DataSource(JuridicalDesignations.AGE, APINames.ADMINISTRES, System.getenv("ADMINISTRES_API_URL")),
            new DataSource(JuridicalDesignations.APTITUDE_MEDICALE, APINames.ESCULAPE, System.getenv("ESCULAPE_API_URL")),
            new DataSource(JuridicalDesignations.FORMATIONS, APINames.AMFORE, System.getenv("AMFORE_API_URL")),
            new DataSource(JuridicalDesignations.TITRES, APINames.ITEM, System.getenv("ITEM_API_URL"))
    ));

    public void compareMarinDataToConditionsTitre(String titreId, String marinId) {
        Map<APINames, String> allMarinData = getMarinDataPort.getAllMarinData(marinId, DATA_SOURCES_MOCK);
        System.out.println(allMarinData);
    }


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
