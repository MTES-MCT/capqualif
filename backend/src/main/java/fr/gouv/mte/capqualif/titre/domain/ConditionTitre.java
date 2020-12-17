package fr.gouv.mte.capqualif.titre.domain;

public class ConditionTitre {

    private String libelle;
    private String valeur;
    private String commentComparer;
    private String existingDataSource;

    public ConditionTitre(String libelle, String valeur, String commentComparer, String existingDataSource) {
        this.libelle = libelle;
        this.valeur = valeur;
        this.commentComparer = commentComparer;
        this.existingDataSource = existingDataSource;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getValeur() {
        return valeur;
    }

    public String getCommentComparer() {
        return commentComparer;
    }

    public String getExistingDataSource() {
        return existingDataSource;
    }
}
