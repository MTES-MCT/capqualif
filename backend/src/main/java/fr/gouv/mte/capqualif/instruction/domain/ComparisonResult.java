package fr.gouv.mte.capqualif.instruction.domain;

public class ComparisonResult {

    private String conditionJuridicalDesignation;
    private boolean isValid;

    public ComparisonResult(String conditionJuridicalDesignation, boolean isValid) {
        this.conditionJuridicalDesignation = conditionJuridicalDesignation;
        this.isValid = isValid;
    }

    public String getConditionJuridicalDesignation() {
        return conditionJuridicalDesignation;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonResult result = (ComparisonResult) o;
        return isValid == result.isValid &&
                conditionJuridicalDesignation.equals(result.conditionJuridicalDesignation);
    }
}
