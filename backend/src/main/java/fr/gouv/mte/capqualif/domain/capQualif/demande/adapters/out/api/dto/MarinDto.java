
package fr.gouv.mte.capqualif.domain.capQualif.demande.adapters.out.api.dto;

// DOC : This object is not a 100% fidelity mapping to the API JSON response.
// Fields that seem unnecessary for our app (ex : codeStatutAdm) are not included in this object.

import java.util.List;

public class MarinDto {
    private String numIdentification;
    private String nom;
    private String nomUsage;
    private String prenom;
    private String villeNaissance;
    private String numeroFixe;
    private String numeroPortable;
    private String adresseMessagerie;
    private String dateNaissance;
    private String dateIdentification;
    private CodeNationalite codeNationalite;
    private CodeCivilite codeCivilite;
    private CodeServiceRattachement codeServiceRattachement;
    private List<TitreOfMarinDto> allTitresOfMarin;

    public String getNumIdentification() {
        return numIdentification;
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

    public CodeNationalite getCodeNationalite() {
        return codeNationalite;
    }

    public CodeCivilite getCodeCivilite() {
        return codeCivilite;
    }

    public CodeServiceRattachement getCodeServiceRattachement() {
        return codeServiceRattachement;
    }

    public List<TitreOfMarinDto> getAllTitresOfMarin() {
        return allTitresOfMarin;
    }

    public void setAllTitresOfMarin(List<TitreOfMarinDto> allTitresOfMarin) {
        this.allTitresOfMarin = allTitresOfMarin;
    }
}