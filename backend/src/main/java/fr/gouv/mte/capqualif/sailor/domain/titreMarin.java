package fr.gouv.mte.capqualif.sailor.domain;

import java.util.List;

public class titreMarin {

    private String id;
    private String numero;
    private String libelle;
    private String dateDelivrance;
    private String dateEffet;
    private String dateExpiration;
    private String autoriteDelivrance;
    private boolean estValide;

    public String getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(String dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(String dateEffet) {
        this.dateEffet = dateEffet;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getAutoriteDelivrance() {
        return autoriteDelivrance;
    }

    public void setAutoriteDelivrance(String autoriteDelivrance) {
        this.autoriteDelivrance = autoriteDelivrance;
    }

    public boolean estValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
}
