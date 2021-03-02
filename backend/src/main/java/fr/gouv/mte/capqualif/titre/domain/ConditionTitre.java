package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;

public class ConditionTitre {

    private String juridicalDesignation;
    private Value mainValueToCheck;
    private List<Value> additionalValuesToCheck;

    public ConditionTitre(String juridicalDesignation, Value mainValueToCheck) {
        this.juridicalDesignation = juridicalDesignation;
        this.mainValueToCheck = mainValueToCheck;
    }

    public ConditionTitre(String juridicalDesignation, Value mainValueToCheck, List<Value> additionalValuesToCheck) {
        this.juridicalDesignation = juridicalDesignation;
        this.mainValueToCheck = mainValueToCheck;
        this.additionalValuesToCheck = additionalValuesToCheck;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public Value getMainValueToCheck() {
        return mainValueToCheck;
    }

    public List<Value> getAdditionalValuesToCheck() {
        return additionalValuesToCheck;
    }
}
