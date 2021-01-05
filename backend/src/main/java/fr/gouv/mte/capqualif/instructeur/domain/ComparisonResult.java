package fr.gouv.mte.capqualif.instructeur.domain;

public class ComparisonResult {

    private String name;
    private boolean isValid;

    public ComparisonResult(String name, boolean isValid) {
        this.name = name;
        this.isValid = isValid;
    }

    public String getName() {
        return name;
    }

    public boolean isValid() {
        return isValid;
    }
}
