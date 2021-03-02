package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;

import java.util.Objects;

public class Value {

    private String valueExpressedInLegalTerms;
    private ComparisonRule howToCompareValue;

    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompareValue) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompareValue = howToCompareValue;
    }

    public String getValueExpressedInLegalTerms() {
        return valueExpressedInLegalTerms;
    }

    public ComparisonRule getHowToCompareValue() {
        return howToCompareValue;
    }

    @Override
    public String toString() {
        return "Value{" +
                "valueExpressedInLegalTerms='" + valueExpressedInLegalTerms + '\'' +
                ", howToCompareValue=" + howToCompareValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Value value = (Value) o;
        return valueExpressedInLegalTerms.equals(value.valueExpressedInLegalTerms) &&
                howToCompareValue == value.howToCompareValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueExpressedInLegalTerms, howToCompareValue);
    }
}
