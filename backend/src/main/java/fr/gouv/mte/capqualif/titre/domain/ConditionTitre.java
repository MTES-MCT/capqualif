package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

public class ConditionTitre {

    private String juridicalDesignation;
    private Value value;
    private ComparisonRule howToCompareValue;
    private ExistingDataSourceName existingDataSourceName;

    public ConditionTitre(String juridicalDesignation, Value value, ComparisonRule howToCompareValue, ExistingDataSourceName existingDataSourceName) {
        this.juridicalDesignation = juridicalDesignation;
        this.value = value;
        this.howToCompareValue = howToCompareValue;
        this.existingDataSourceName = existingDataSourceName;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public Value getValue() {
        return value;
    }

    public ComparisonRule getHowToCompareValue() {
        return howToCompareValue;
    }

    public ExistingDataSourceName getExistingDataSource() {
        return existingDataSourceName;
    }
}
