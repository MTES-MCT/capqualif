package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.List;

public class ParseResult {
    private final boolean conditionsSatisfied;
    private final List<ConditionResult> errors;

    public ParseResult(boolean conditionsSatisfied, List<ConditionResult> errors) {
        this.conditionsSatisfied = conditionsSatisfied;
        this.errors = errors;
    }

    public boolean areConditionsSatisfied() {
        return conditionsSatisfied;
    }

    public List<ConditionResult> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ParseResult{" +
                "conditionsSatisfied=" + conditionsSatisfied +
                ", errors=" + errors +
                '}';
    }
}