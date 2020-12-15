package fr.gouv.mte.capqualif.titre.domain;

public class ConditionTitre {

    private String valeur;
    private String existingDataSource;

    public ConditionTitre(String valeur, String existingDataSource) {
        this.valeur = valeur;
        this.existingDataSource = existingDataSource;
    }

    public String getValeur() {
        return valeur;
    }

    public String getExistingDataSource() {
        return existingDataSource;
    }
}
