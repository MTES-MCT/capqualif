package fr.gouv.mte.capqualif.instructeur.domain;

public class CompareResult {

    private String libelle;
    private boolean isValid;

    public CompareResult(String libelle, boolean isValid) {
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
