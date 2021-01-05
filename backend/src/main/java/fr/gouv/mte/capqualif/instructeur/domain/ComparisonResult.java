package fr.gouv.mte.capqualif.instructeur.domain;

public class ComparisonResult {

    private String libelle;
    private boolean isValid;

    public ComparisonResult(String libelle, boolean isValid) {
        this.libelle = libelle;
        this.isValid = isValid;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isValid() {
        return isValid;
    }
}
