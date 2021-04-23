package fr.gouv.mte.capqualif.capAdmin.titreTemp.domain;

import java.util.List;

public class ConditionTitre {

    private final String juridicalDesignation;
    private final Value mainValueToCheck;
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
