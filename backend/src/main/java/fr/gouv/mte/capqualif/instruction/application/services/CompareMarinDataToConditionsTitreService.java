package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.CorrespondingDataInExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataSource;
import fr.gouv.mte.capqualif.legislateur.mock.KeyInExistingDataSource;
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

    @Override
    public List<ComparisonResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {
        List<ConditionTitre> conditions = getTitrePort.findTitreById(titreId).getConditions();
        List<ComparisonResult> results = new ArrayList<ComparisonResult>();
        for (ConditionTitre condition : conditions) {
            CorrespondingDataInExistingDataSource conditionRealData =
                    existingDataSource.findByConditionValue(condition);
            List<ExtractionResult> marinMatchingData = getMarinDataPort.getMarinData(numeroDeMarin, conditionRealData);
            compareMarinDataToConditionCriteria(numeroDeMarin, results, condition, conditionRealData,
                    marinMatchingData);
        }
        return results;
    }

    private void compareMarinDataToConditionCriteria(String numeroDeMarin, List<ComparisonResult> results,
                                                     ConditionTitre condition,
                                                     CorrespondingDataInExistingDataSource conditionRealData,
                                                     List<ExtractionResult> marinMatchingData) {
        isMarinDataMeetingMainConditionCriterion(results, marinMatchingData, conditionRealData);
        isMarinDataMeetingAdditionalConditionCriteria(results, marinMatchingData, conditionRealData);
    }

    private void isMarinDataMeetingMainConditionCriterion(List<ComparisonResult> results,
                                                          List<ExtractionResult> marinMatchingData,
                                                          CorrespondingDataInExistingDataSource correspondingData) {

        ComparisonResult comparisonResult;
        for (ExtractionResult marinData : marinMatchingData) {
            if (marinData.getKey().equals(correspondingData.getMainWantedData().getKeyInExistingDataSource().getJuridicalName())) {
                if (marinData.getValue().equals(correspondingData.getMainWantedData().getValueInExistingDataSource().getContent())) {
                    comparisonResult =
                            buildComparisonResult(correspondingData.getMainWantedData().getKeyInExistingDataSource().getJuridicalName(), true);
                } else {
                    comparisonResult =
                            buildComparisonResult(correspondingData.getMainWantedData().getKeyInExistingDataSource().getJuridicalName(), false);
                }
                results.add(comparisonResult);
            }
        }
    }

    private void isMarinDataMeetingAdditionalConditionCriteria(List<ComparisonResult> results,
                                                               List<ExtractionResult> marinMatchingData,
                                                               CorrespondingDataInExistingDataSource correspondingData) {
        ComparisonResult comparisonResult;

        for (KeyInExistingDataSource key : correspondingData.getKeysOfAdditionalWantedData()) {
            for (ExtractionResult marinData : marinMatchingData) {
                if (marinData.getKey().equals(key.getRealNameInExistingDataSource())) {
                    // vérifier la validité de la date
                    comparisonResult = buildComparisonResult(key.getJuridicalName(), true);
                } else {
                    comparisonResult = buildComparisonResult(key.getJuridicalName(), false);
                }
                results.add(comparisonResult);
            }
        }

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
