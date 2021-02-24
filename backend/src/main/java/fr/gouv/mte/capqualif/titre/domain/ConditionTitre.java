package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

public class ConditionTitre {

    private String juridicalDesignation;
    private String valueExpressedInLegalTerms;
    private ComparisonRule howToCompareValue;

    public ConditionTitre(String juridicalDesignation, String valueExpressedInLegalTerms,
                          ComparisonRule howToCompareValue) {
        this.juridicalDesignation = juridicalDesignation;
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompareValue = howToCompareValue;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public String getValueExpressedInLegalTerms() {
        return valueExpressedInLegalTerms;
    }

    public ComparisonRule getHowToCompareValue() {
        return howToCompareValue;
    }
}
