package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.IReferenceData;

import java.util.Objects;

public class Value {

    private String valueExpressedInLegalTerms;
    private ComparisonRule howToCompare;
    private IReferenceData IReferenceData;

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
     * This constructor is for values that are used in comparisons to references other than value expressed in legal terms
     * @param valueExpressedInLegalTerms
     * @param howToCompare
     * @param IReferenceData
     *              can be string or date
     */
    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompare, IReferenceData IReferenceData) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompare = howToCompare;
        this.IReferenceData = IReferenceData;
    }

    public String getValueExpressedInLegalTerms() {
        return valueExpressedInLegalTerms;
    }

    public ComparisonRule getHowToCompare() {
        return howToCompare;
    }

    public IReferenceData getReferenceData() {
        return IReferenceData;
    }

    @Override
    public String toString() {
        return "Value{" +
                "valueExpressedInLegalTerms='" + valueExpressedInLegalTerms + '\'' +
                ", howToCompare=" + howToCompare +
                ", referenceData=" + IReferenceData +
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
                Objects.equals(IReferenceData, value.IReferenceData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueExpressedInLegalTerms, howToCompare, IReferenceData);
    }
}
