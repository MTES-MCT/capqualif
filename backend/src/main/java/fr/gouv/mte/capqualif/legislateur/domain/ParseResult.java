package fr.gouv.mte.capqualif.legislateur.domain;

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
}