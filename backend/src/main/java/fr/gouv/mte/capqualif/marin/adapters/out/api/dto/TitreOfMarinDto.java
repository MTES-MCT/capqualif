
package fr.gouv.mte.capqualif.marin.adapters.out.api.dto;

import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.restriction.ListTitreCapacite;

import java.util.List;

public class TitreOfMarinDto {

    private String numeroTitre;
    private String dateDelivrance;
    private String dateRevalidation;
    private String dateEffet;
    private String dateExpiration;
    private CodeEtatTitre codeEtatTitre;
    private CodeBrevetMarin codeBrevetMarin;
    private CodeAutoriteDelivrance codeAutoriteDelivrance;
    private List<ListTitreCapacite> listTitreCapacite;


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

    public List<ListTitreCapacite> getListTitreCapacite() {
        return listTitreCapacite;
    }
}
