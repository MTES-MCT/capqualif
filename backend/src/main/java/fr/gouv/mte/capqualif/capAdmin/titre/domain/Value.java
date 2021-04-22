package fr.gouv.mte.capqualif.capAdmin.titre.domain;

import java.util.Objects;

public class Value {

    private String valueExpressedInLegalTerms;
    private ComparisonRule howToCompare;
    private ComparisonData comparisonData;

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
     * @param comparisonData
     *              can be string or date
     */
    public Value(String valueExpressedInLegalTerms, ComparisonRule howToCompare, ComparisonData comparisonData) {
        this.valueExpressedInLegalTerms = valueExpressedInLegalTerms;
        this.howToCompare = howToCompare;
        this.comparisonData = comparisonData;
    }




    public String getValueExpressedInLegalTerms() {
        return valueExpressedInLegalTerms;
    }

    public ComparisonRule getHowToCompare() {
        return howToCompare;
    }

    public ComparisonData getComparisonData() {
        return comparisonData;
    }

    @Override
    public String toString() {
        return "Value{" +
                "valueExpressedInLegalTerms='" + valueExpressedInLegalTerms + '\'' +
                ", howToCompare=" + howToCompare +
                ", comparisonData=" + comparisonData +
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
                comparisonData.equals(value.comparisonData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueExpressedInLegalTerms, howToCompare, comparisonData);
    }
}
