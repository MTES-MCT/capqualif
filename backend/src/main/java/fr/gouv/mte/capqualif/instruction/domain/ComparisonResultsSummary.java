package fr.gouv.mte.capqualif.instruction.domain;

import java.util.List;
import java.util.Objects;

public class ComparisonResultsSummary {

    private ComparisonResult comparisonResultForMainCriterion;
    private List<ComparisonResult> comparisonResultsForAdditionalCriteria;

    public ComparisonResultsSummary(ComparisonResult comparisonResultForMainCriterion, List<ComparisonResult> comparisonResultsForAdditionalCriteria) {
        this.comparisonResultForMainCriterion = comparisonResultForMainCriterion;
        this.comparisonResultsForAdditionalCriteria = comparisonResultsForAdditionalCriteria;
    }

    public ComparisonResult getComparisonResultForMainCriterion() {
        return comparisonResultForMainCriterion;
    }

    public List<ComparisonResult> getComparisonResultsForAdditionalCriteria() {
        return comparisonResultsForAdditionalCriteria;
    }

    public void setComparisonResultForMainCriterion(ComparisonResult comparisonResultForMainCriterion) {
        this.comparisonResultForMainCriterion = comparisonResultForMainCriterion;
    }

    public void setComparisonResultsForAdditionalCriteria(List<ComparisonResult> comparisonResultsForAdditionalCriteria) {
        this.comparisonResultsForAdditionalCriteria = comparisonResultsForAdditionalCriteria;
    }

    @Override
    public String toString() {
        return "AllComparisonResults{" +
                "comparisonResultForMainCriterion=" + comparisonResultForMainCriterion +
                ", comparisonResultsForAdditionalCriteria=" + comparisonResultsForAdditionalCriteria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonResultsSummary that = (ComparisonResultsSummary) o;
        return comparisonResultForMainCriterion.equals(that.comparisonResultForMainCriterion) &&
                Objects.equals(comparisonResultsForAdditionalCriteria, that.comparisonResultsForAdditionalCriteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comparisonResultForMainCriterion, comparisonResultsForAdditionalCriteria);
    }
}
