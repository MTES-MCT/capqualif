
package fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api.dto;

import java.util.List;

public class TitreOfMarinDto {

    private String idIteTitreDetenu;
    private String numeroTitre;
    private String dateDelivrance;
    private String dateRevalidation;
    private String dateEffet;
    private String dateExpiration;
    private CodeEtatTitre codeEtatTitre;
    private CodeBrevetMarin codeBrevetMarin;
    private CodeAutoriteDelivrance codeAutoriteDelivrance;
    private List<TitreCapaciteRest> listTitreCapacite;

    public String getIdIteTitreDetenu() {
        return idIteTitreDetenu;
    }

    public String getNumeroTitre() {
        return numeroTitre;
    }

    public String getDateDelivrance() {
        return dateDelivrance;
    }

    public String getDateRevalidation() {
        return dateRevalidation;
    }

    public String getDateEffet() {
        return dateEffet;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public CodeEtatTitre getCodeEtatTitreDTO() {
        return codeEtatTitre;
    }

    public CodeBrevetMarin getCodeBrevetMarinDTO() {
        return codeBrevetMarin;
    }

    public CodeAutoriteDelivrance getCodeAutoriteDelivranceDTO() {
        return codeAutoriteDelivrance;
    }

    public List<TitreCapaciteRest> getListTitreCapacite() {
        return listTitreCapacite;
    }
}
