package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.List;

public class ParseResult {
    private final boolean areConditionsSatisfied;
    private final List<String> errors;

    public ParseResult(boolean areConditionsSatisfied, List<String> errors) {
        this.areConditionsSatisfied = areConditionsSatisfied;
        this.errors = errors;
    }

    public boolean isAreConditionsSatisfied() {
        return areConditionsSatisfied;
    }

    public List<String> getErrors() {
        return errors;
    }
}
