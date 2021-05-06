
package fr.gouv.mte.capqualif.capQualif.demande.domain.marin;

import java.util.List;

public class Marin {
    private String numeroDeMarin;
    private String nom;
    private String nomUsage;
    private String prenom;
    private String villeNaissance;
    private String numeroFixe;
    private String numeroPortable;
    private String adresseMessagerie;
    private String dateNaissance;
    private String dateIdentification;
    private String nationalite;
    private String civilite;
    private String serviceRattachement;
    private List<TitreOfMarin> allTitresOfMarin;

    public Marin(String numeroDeMarin, String nom, String nomUsage, String prenom, String villeNaissance,
                 String numeroFixe, String numeroPortable, String adresseMessagerie, String dateNaissance,
                 String dateIdentification, String nationalite, String civilite, String serviceRattachement) {
        this.numeroDeMarin = numeroDeMarin;
        this.nom = nom;
        this.nomUsage = nomUsage;
        this.prenom = prenom;
        this.villeNaissance = villeNaissance;
        this.numeroFixe = numeroFixe;
        this.numeroPortable = numeroPortable;
        this.adresseMessagerie = adresseMessagerie;
        this.dateNaissance = dateNaissance;
        this.dateIdentification = dateIdentification;
        this.nationalite = nationalite;
        this.civilite = civilite;
        this.serviceRattachement = serviceRattachement;
    }

    public void setAllTitresOfMarin(List<TitreOfMarin> allTitresOfMarin) {
        this.allTitresOfMarin = allTitresOfMarin;
    }

    public String getNumeroDeMarin() {
        return numeroDeMarin;
    }

    public String getNom() {
        return nom;
    }

    public String getNomUsage() {
        return nomUsage;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public String getNumeroFixe() {
        return numeroFixe;
    }

    public String getNumeroPortable() {
        return numeroPortable;
    }

    public String getAdresseMessagerie() {
        return adresseMessagerie;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getDateIdentification() {
        return dateIdentification;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getServiceRattachement() {
        return serviceRattachement;
    }

    public List<TitreOfMarin> getAllTitresOfMarin() {
        return allTitresOfMarin;
    }
}