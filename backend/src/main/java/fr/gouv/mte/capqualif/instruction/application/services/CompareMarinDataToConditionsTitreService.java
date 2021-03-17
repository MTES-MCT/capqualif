package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResultsSummary;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.CorrespondingDataInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.EntryInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.KeyInExistingDataSource;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.ComparisonData;
import fr.gouv.mte.capqualif.titre.domain.ComparisonDate;
import fr.gouv.mte.capqualif.titre.domain.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.ComparisonString;
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
                                                    ExistingDataSource existingDataSource,
                                                    TimeConverter timeConverter) {
        this.getTitrePort = getTitrePort;
        this.getMarinDataPort = getMarinDataPort;
        this.existingDataSource = existingDataSource;
        this.timeConverter = timeConverter;
    }

    @Override
    public List<ComparisonResultsSummary> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {

        List<ConditionTitre> conditions = getTitrePort.findTitreById(titreId).getConditions();
        List<ComparisonResultsSummary> allComparisonResultSummaries = new ArrayList<>();

        for (ConditionTitre condition : conditions) {

            CorrespondingDataInExistingDataSource conditionRealData =
                    existingDataSource.findByConditionValue(condition);

            List<ExtractionResult> marinMatchingData = getMarinDataPort.getMarinData(numeroDeMarin, conditionRealData);

            ComparisonResultsSummary comparisonResultsSummary = new ComparisonResultsSummary(null, null);

            if (marinMatchingData.size() > 0) {
                compareMarinDataToConditionCriteria(comparisonResultsSummary, condition, conditionRealData, marinMatchingData);
                allComparisonResultSummaries.add(comparisonResultsSummary);
            }
        }
        return allComparisonResultSummaries;
    }

    private void compareMarinDataToConditionCriteria(ComparisonResultsSummary comparisonResultsSummary,
                                                     ConditionTitre condition,
                                                     CorrespondingDataInExistingDataSource conditionRealData,
                                                     List<ExtractionResult> marinMatchingData) {
        if (conditionRealData.getMainWantedData() != null)
            isMarinDataMeetingMainConditionCriterion(comparisonResultsSummary, conditionRealData.getMainWantedData(), marinMatchingData);
        if (conditionRealData.getKeysOfAdditionalWantedData() != null)
            isMarinDataMeetingAdditionalConditionCriteria(comparisonResultsSummary, conditionRealData.getKeysOfAdditionalWantedData(), marinMatchingData);
    }

    private void isMarinDataMeetingMainConditionCriterion(ComparisonResultsSummary comparisonResultsSummary,
                                                          EntryInExistingDataSource conditionData,
                                                          List<ExtractionResult> marinMatchingData) {
        for (ExtractionResult marinData : marinMatchingData) {
            if (marinDataKeyEqualReferenceKey(marinData, conditionData.getKeyInExistingDataSource())) {
                compareForMainCriterion(comparisonResultsSummary, conditionData, marinData);
            }
        }
    }

    private void compareForMainCriterion(ComparisonResultsSummary comparisonResultsSummary,
                                         EntryInExistingDataSource conditionData, ExtractionResult marinData) {
        ComparisonResult comparisonResult;
        switch (conditionData.getKeyInExistingDataSource().getDataType()) {
            case STRING:
                boolean stringComparisonResult =
                        compareStrings(
                                marinData.getValue(),
                                new ComparisonString(conditionData.getValueInExistingDataSource().getContent()),
                                conditionData.getKeyInExistingDataSource().getComparisonRule()
                        );
                comparisonResult =
                        buildComparisonResult(conditionData.getKeyInExistingDataSource().getJuridicalName(),
                                stringComparisonResult,
                                buildComment(
                                        new ComparisonString(marinData.getValue()),
                                        new ComparisonString(conditionData.getValueInExistingDataSource().getContent()),
                                        conditionData.getKeyInExistingDataSource().getComparisonRule(),
                                        stringComparisonResult
                                )
                        );
                comparisonResultsSummary.setComparisonResultForMainCriterion(comparisonResult);
                break;
            case DATE:
                boolean dateComparisonResult = compareDates(
                        timeConverter.convertToLocalDate(marinData.getValue()),
                        (ComparisonDate) conditionData.getKeyInExistingDataSource().getComparisonReference(), //
                        // TO-DO : rewrite better
                        conditionData.getKeyInExistingDataSource().getComparisonRule()
                );
                comparisonResult =
                        buildComparisonResult(conditionData.getKeyInExistingDataSource().getJuridicalName(),
                                dateComparisonResult,
                                buildComment(
                                        new ComparisonDate(timeConverter.convertToLocalDate(marinData.getValue())),
                                        conditionData.getKeyInExistingDataSource().getComparisonReference(),
                                        conditionData.getKeyInExistingDataSource().getComparisonRule(),
                                        dateComparisonResult
                                ));
                comparisonResultsSummary.setComparisonResultForMainCriterion(comparisonResult);
                break;
        }
    }

    private void isMarinDataMeetingAdditionalConditionCriteria(ComparisonResultsSummary comparisonResultsSummary,
                                                               List<KeyInExistingDataSource> additionalData,
                                                               List<ExtractionResult> marinMatchingData) {
        List<ComparisonResult> additionalCriteriaComparisonResults = new ArrayList<>();
        for (KeyInExistingDataSource key : additionalData) {
            for (ExtractionResult marinData : marinMatchingData) {
                if (marinDataKeyEqualReferenceKey(marinData, key)) {
                    compareForAdditionalCriterion(additionalCriteriaComparisonResults, key, marinData);
                }
            }
        }
        comparisonResultsSummary.setComparisonResultsForAdditionalCriteria(additionalCriteriaComparisonResults);
    }

    private void compareForAdditionalCriterion(List<ComparisonResult> additionalCriteriaComparisonResults,
                                               KeyInExistingDataSource key, ExtractionResult marinData) {
        ComparisonResult comparisonResult;
        switch (key.getDataType()) {
            case STRING:
                boolean stringComparisonResult = compareStrings(
                        marinData.getValue(),
                        new ComparisonString(key.getComparisonReference().getValue()),
                        key.getComparisonRule()
                );
                comparisonResult =
                        buildComparisonResult(key.getJuridicalName(), stringComparisonResult,
                                buildComment(new ComparisonString(marinData.getValue()), key.getComparisonReference()
                                        , key.getComparisonRule(), stringComparisonResult));
                additionalCriteriaComparisonResults.add(comparisonResult);
                break;
            case DATE:
                boolean dateComparisonResult = compareDates(
                        timeConverter.convertToLocalDate(marinData.getValue()),
                        (ComparisonDate) key.getComparisonReference(),
                        key.getComparisonRule()
                );
                comparisonResult =
                        buildComparisonResult(
                                key.getJuridicalName(),
                                dateComparisonResult,
                                buildComment(
                                        new ComparisonDate(
                                            timeConverter.convertToLocalDate(marinData.getValue())),
                                            key.getComparisonReference(),
                                            key.getComparisonRule(),
                                            dateComparisonResult
                                )
                        );
                additionalCriteriaComparisonResults.add(comparisonResult);
                break;
        }
    };

    private boolean marinDataKeyEqualReferenceKey(ExtractionResult marinData,
                                                  KeyInExistingDataSource keyInExistingDataSource) {
        return marinData.getKey().equals(keyInExistingDataSource.getJuridicalName());
    }

    private boolean compareStrings(String comparedData, ComparisonString referenceString,
                                   ComparisonRule comparisonRule) {
        // TO DO : add more cases if needed
        boolean result = false;
        switch (comparisonRule) {
            case STRICT_EQUALITY:
                if (comparedData.equals(referenceString.getReference())) {
                    result = true;
                }
                break;
            default:
                return false;
        }
        return result;
    }

    ;

    private boolean compareDates(LocalDate comparedDate, ComparisonDate referenceDate, ComparisonRule comparisonRule) {
        LocalDate refDate = referenceDate.getData();
        boolean result = false;
        switch (comparisonRule) {
            case EQUAL_TO_OR_POSTERIOR:
                if (comparedDate.isAfter(refDate) || comparedDate.isEqual(refDate)) {
                    result = true;
                }
                break;
            case EQUAL_TO_OR_ANTERIOR:
                if (comparedDate.isBefore(refDate) || comparedDate.isEqual(refDate)) {
                    result = true;
                }
                break;
            case STRICTLY_ANTERIOR:
                if (comparedDate.isBefore(refDate)) {
                    result = true;
                }
                break;
            case STRICTLY_POSTERIOR:
                if (comparedDate.isAfter(refDate)) {
                    result = true;
                }
                break;
            default:
                return false;
        }
        return result;
    }

    private ComparisonResult buildComparisonResult(String key, boolean isMarinDataMeetingConditionCriterion,
                                                   String comment) {
        return new ComparisonResult(key, isMarinDataMeetingConditionCriterion, comment);
    }

    private String buildComment(ComparisonData comparedData, ComparisonData comparisonData,
                                ComparisonRule comparisonRule, boolean comparisonResult) {
        return "Marin's data '"
                + comparedData.getValue()
                + "' "
                + (comparisonResult ? "meets " : "does not meet ")
                + comparisonRule.toString() + " rule when compared to " + comparisonData.getValue();
    }

}
