package fr.gouv.mte.capqualif.capAdmin.domain;

import java.util.List;

public class ParseResult {
    private final boolean conditionsSatisfied;
    private final List<String> errors;

    public ParseResult(boolean conditionsSatisfied, List<String> errors) {
        this.conditionsSatisfied = conditionsSatisfied;
        this.errors = errors;
    }

    public boolean areConditionsSatisfied() {
        return conditionsSatisfied;
    }

    public List<String> getErrors() {
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