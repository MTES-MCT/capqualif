package fr.gouv.mte.capqualif.instructeur.domain;

public class CompareResult {

    private String label;
    private boolean isValid;

    public CompareResult(String label, boolean isValid) {
        this.label = label;
        this.isValid = isValid;
    }

    public String getLabel() {
        return label;
    }

    public boolean isValid() {
        return isValid;
    }
}
