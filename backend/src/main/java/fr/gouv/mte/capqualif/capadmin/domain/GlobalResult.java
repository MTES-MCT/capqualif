package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.List;
import java.util.Objects;

public class GlobalResult {
    private final boolean conditionsSatisfied;
    private final List<ConditionResult> details;

    public GlobalResult(boolean conditionsSatisfied, List<ConditionResult> details) {
        this.conditionsSatisfied = conditionsSatisfied;
        this.details = details;
    }

    public boolean areConditionsSatisfied() {
        return conditionsSatisfied;
    }

    public List<ConditionResult> getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GlobalResult that = (GlobalResult) o;
        return conditionsSatisfied == that.conditionsSatisfied &&
                details.equals(that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditionsSatisfied, details);
    }

    @Override
    public String toString() {
        return "GlobalResult{" +
                "conditionsSatisfied=" + conditionsSatisfied +
                ", details=" + details +
                '}';
    }
}