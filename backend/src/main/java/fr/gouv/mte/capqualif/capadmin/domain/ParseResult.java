package fr.gouv.mte.capqualif.capAdmin.domain;

import java.util.List;

public class ParseResult {
    private final boolean conditionsSatisfied;
    private final List<ConditionIdentity> errors;

    public ParseResult(boolean conditionsSatisfied, List<ConditionIdentity> errors) {
        this.conditionsSatisfied = conditionsSatisfied;
        this.errors = errors;
    }

    public boolean areConditionsSatisfied() {
        return conditionsSatisfied;
    }

    public List<ConditionIdentity> getErrors() {
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