package fr.gouv.mte.capqualif.domain.capQualif.instruction.domain;

import java.util.Objects;

public class ComparisonResult {

    private String conditionJuridicalDesignation;
    private boolean isValid;
    private String comment;

    public ComparisonResult(String conditionJuridicalDesignation, boolean isValid, String comment) {
        this.conditionJuridicalDesignation = conditionJuridicalDesignation;
        this.isValid = isValid;
        this.comment = comment;
    }

    public String getConditionJuridicalDesignation() {
        return conditionJuridicalDesignation;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "ComparisonResult{" +
                "conditionJuridicalDesignation='" + conditionJuridicalDesignation + '\'' +
                ", isValid=" + isValid +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonResult that = (ComparisonResult) o;
        return isValid == that.isValid &&
                conditionJuridicalDesignation.equals(that.conditionJuridicalDesignation) &&
                comment.equals(that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditionJuridicalDesignation, isValid, comment);
    }
}
