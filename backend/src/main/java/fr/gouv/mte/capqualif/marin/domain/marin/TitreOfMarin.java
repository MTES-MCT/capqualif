
package fr.gouv.mte.capqualif.marin.domain.marin;

import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.CodeAutoriteDelivrance;
import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.CodeBrevetMarin;
import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.CodeEtatTitre;
import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.restriction.ListTitreCapacite;

import java.util.List;

public class TitreOfMarin {

    private String numeroDuTitre;
    private String name;
    private String delivranceDate;
    private String revalidationDate;
    private String effetDate;
    private String expirationDate;
    private String isValid;
    private String autoriteDeDelivrance;
    private List<ListTitreCapacite> restrictions;

    public TitreOfMarin(String numeroDuTitre, String name, String delivranceDate, String revalidationDate,
                        String effetDate, String expirationDate, String isValid, String autoriteDeDelivrance,
                        List<ListTitreCapacite> restrictions) {
        this.numeroDuTitre = numeroDuTitre;
        this.name = name;
        this.delivranceDate = delivranceDate;
        this.revalidationDate = revalidationDate;
        this.effetDate = effetDate;
        this.expirationDate = expirationDate;
        this.isValid = isValid;
        this.autoriteDeDelivrance = autoriteDeDelivrance;
        this.restrictions = restrictions;
    }

    public String getNumeroDuTitre() {
        return numeroDuTitre;
    }

    public String getName() {
        return name;
    }

    public String getDelivranceDate() {
        return delivranceDate;
    }

    public String getRevalidationDate() {
        return revalidationDate;
    }

    public String getEffetDate() {
        return effetDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getIsValid() {
        return isValid;
    }

    public String getAutoriteDeDelivrance() {
        return autoriteDeDelivrance;
    }

    public List<ListTitreCapacite> getRestrictions() {
        return restrictions;
    }
}
