package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.CorrespondingDataInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.EntryInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.KeyInExistingDataSource;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonData;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonDate;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonString;
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
    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
        List<ConditionTitre> conditions = getTitrePort.findTitreById(titreId).getConditions();

        List<ComparisonResult> results = new ArrayList<ComparisonResult>();

        for (ConditionTitre condition : conditions) {
            CorrespondingDataInExistingDataSource conditionRealData =
                    existingDataSource.findByConditionValue(condition);
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
        isMarinDataMeetingMainConditionCriterion(results, conditionRealData.getMainWantedData(), marinMatchingData);
        isMarinDataMeetingAdditionalConditionCriteria(results, conditionRealData.getKeysOfAdditionalWantedData(),
                marinMatchingData);
    }

    private void isMarinDataMeetingMainConditionCriterion(List<ComparisonResult> results,
                                                          EntryInExistingDataSource conditionData,
                                                          List<ExtractionResult> marinMatchingData) {
        ComparisonResult comparisonResult;
        for (ExtractionResult marinData : marinMatchingData) {
            if (marinDataKeyEqualReferenceKey(marinData, conditionData.getKeyInExistingDataSource())) {
                compareForMainCriterion(results, conditionData, marinData);
            }
        }
    }

    private void compareForMainCriterion(List<ComparisonResult> results, EntryInExistingDataSource conditionData,
                                         ExtractionResult marinData) {
        ComparisonResult comparisonResult;
        switch (conditionData.getKeyInExistingDataSource().getDataType()) {
            case STRING:
                boolean stringComparisonResult = compareStrings(marinData.getValue(),
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
                results.add(comparisonResult);
                break;
            case DATE:
                boolean dateComparisonResult = compareDates(
                        timeConverter.convertToLocalDate(marinData.getValue()),
                        (ComparisonDate) conditionData.getKeyInExistingDataSource().getComparisonReference(),
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
                results.add(comparisonResult);
                break;
        }
    }

    private void isMarinDataMeetingAdditionalConditionCriteria(List<ComparisonResult> results,
                                                               List<KeyInExistingDataSource> additionalData,
                                                               List<ExtractionResult> marinMatchingData) {
        ComparisonResult comparisonResult;
        for (KeyInExistingDataSource key : additionalData) {
            for (ExtractionResult marinData : marinMatchingData) {
                if (marinDataKeyEqualReferenceKey(marinData, key)) {
                    compareForAdditionalCriteria(results, key, marinData);
                }
            }
        }
    }

    private void compareForAdditionalCriteria(List<ComparisonResult> results, KeyInExistingDataSource key,
                                              ExtractionResult marinData) {
        ComparisonResult comparisonResult;
        switch (key.getDataType()) {
            case STRING:
                boolean stringComparisonResult = compareStrings(
                        marinData.getValue(),
                        (ComparisonString) key.getComparisonReference(),
                        key.getComparisonRule()
                );
                comparisonResult =
                        buildComparisonResult(key.getJuridicalName(), stringComparisonResult,
                                buildComment(new ComparisonString(marinData.getValue()),
                                        key.getComparisonReference(), key.getComparisonRule(),
                                        stringComparisonResult));
                results.add(comparisonResult);
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
                                        new ComparisonDate(timeConverter.convertToLocalDate(marinData.getValue())),
                                        key.getComparisonReference(), key.getComparisonRule(), dateComparisonResult));
                results.add(comparisonResult);
                break;
        }
    }

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
        ComparisonResult comparisonResult;
        comparisonResult = new ComparisonResult(key, isMarinDataMeetingConditionCriterion, comment);
        return comparisonResult;
    }

    private String buildComment(ComparisonData comparedData, ComparisonData comparisonData,
                                ComparisonRule comparisonRule, boolean comparisonResult) {
        return "Marin's data '" + comparedData
                + (comparisonResult ? "meets" : "does not meet ")
                + comparisonRule.toString() + " rule when compared to " + comparisonData.getValue();
    }

}
