package fr.gouv.mte.capqualif.capQualif.instruction.domain;

import java.util.List;
import java.util.Objects;

public class ComparisonsSummary {

    private boolean isConditionMet;
    private ComparisonResult comparisonResultForMainCriterion;
    private List<ComparisonResult> comparisonResultsForAdditionalCriteria;

    public ComparisonsSummary(boolean isConditionMet, ComparisonResult comparisonResultForMainCriterion,
                              List<ComparisonResult> comparisonResultsForAdditionalCriteria) {
        this.isConditionMet = isConditionMet;
        this.comparisonResultForMainCriterion = comparisonResultForMainCriterion;
        this.comparisonResultsForAdditionalCriteria = comparisonResultsForAdditionalCriteria;
    }

    public void setConditionMet(boolean conditionMet) {
        isConditionMet = conditionMet;
    }

    public boolean isConditionMet() {
        return isConditionMet;
    }

    public ComparisonResult getComparisonResultForMainCriterion() {
        return comparisonResultForMainCriterion;
    }

    public void setComparisonResultForMainCriterion(ComparisonResult comparisonResultForMainCriterion) {
        this.comparisonResultForMainCriterion = comparisonResultForMainCriterion;
    }

    public List<ComparisonResult> getComparisonResultsForAdditionalCriteria() {
        return comparisonResultsForAdditionalCriteria;
    }

    public void setComparisonResultsForAdditionalCriteria(List<ComparisonResult> comparisonResultsForAdditionalCriteria) {
        this.comparisonResultsForAdditionalCriteria = comparisonResultsForAdditionalCriteria;
    }

    @Override
    public String toString() {
        return "ComparisonResultsSummary{" +
                "isConditionMet=" + isConditionMet +
                ", comparisonResultForMainCriterion=" + comparisonResultForMainCriterion +
                ", comparisonResultsForAdditionalCriteria=" + comparisonResultsForAdditionalCriteria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonsSummary that = (ComparisonsSummary) o;
        return isConditionMet == that.isConditionMet &&
                comparisonResultForMainCriterion.equals(that.comparisonResultForMainCriterion) &&
                Objects.equals(comparisonResultsForAdditionalCriteria, that.comparisonResultsForAdditionalCriteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConditionMet, comparisonResultForMainCriterion, comparisonResultsForAdditionalCriteria);
    }
}
