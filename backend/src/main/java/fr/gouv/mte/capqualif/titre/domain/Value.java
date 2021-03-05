package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;

import java.time.LocalDate;
import java.util.Objects;

public class Value {

    private String valueExpressedInLegalTerms;
    private ComparisonRule howToCompare;
    private LocalDate referenceDate;

    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompare) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompare = howToCompare;
    }

    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompare, LocalDate referenceDate) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompare = howToCompare;
        this.referenceDate = referenceDate;
    }

    public String getValueExpressedInLegalTerms() {
        return valueExpressedInLegalTerms;
    }

    public ComparisonRule getHowToCompare() {
        return howToCompare;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    @Override
    public String toString() {
        return "Value{" +
                "valueExpressedInLegalTerms='" + valueExpressedInLegalTerms + '\'' +
                ", howToCompare=" + howToCompare +
                ", referenceDate=" + referenceDate +
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
                howToCompare == value.howToCompare &&
                Objects.equals(referenceDate, value.referenceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueExpressedInLegalTerms, howToCompare, referenceDate);
    }
}
