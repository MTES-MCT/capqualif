package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ReferenceData;
import fr.gouv.mte.capqualif.titre.domain.enums.ReferenceString;
import fr.gouv.mte.capqualif.titre.domain.enums.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Value {

    private String valueExpressedInLegalTerms;
    private ComparisonRule howToCompare;
    private ReferenceData referenceData;

    /**
     * This constructor is for values that are used in comparisons to value expressed in legal terms
     * @param valueExpressedInLegalTerms
     * @param howToCompare
     */
    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompare) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompare = howToCompare;
    }

    /**
     * This constructor is for values that are used in comparisons to string references (other than value expressed in legal terms)
     * @param valueExpressedInLegalTerms
     * @param howToCompare
     * @param referenceString
     */
    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompare, ReferenceString referenceString) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompare = howToCompare;
        this.referenceString = referenceString;
    }

    /**
     * This constructor is for values that are used in comparisons to date references
     * @param valueExpressedInLegalTerms
     * @param howToCompare
     * @param referenceDate
     */
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

    public ReferenceData getReferenceString() {
        return referenceString;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    @Override
    public String toString() {
        return "Value{" +
                "valueExpressedInLegalTerms='" + valueExpressedInLegalTerms + '\'' +
                ", howToCompare=" + howToCompare +
                ", referenceString=" + referenceString +
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
                Objects.equals(referenceString, value.referenceString) &&
                Objects.equals(referenceDate, value.referenceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueExpressedInLegalTerms, howToCompare, referenceString, referenceDate);
    }
}
