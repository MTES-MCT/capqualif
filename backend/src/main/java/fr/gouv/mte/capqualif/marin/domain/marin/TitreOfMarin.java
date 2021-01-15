
package fr.gouv.mte.capqualif.marin.domain.marin;

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
    private List<String> restrictionsInStandardFormat;
    private List<String> restrictionsInStandardFormatEnglish;
    private List<String> restrictionInFreeFormat;
    private List<String> restrictionInFreeFormatEnglish;

    // TO DO : get these data ASAP from a "titres catalog" module.
    // These data are generic and attached to a title, not specific for a marin
    // therefore they should not be here!
    private String capacite;
    private String capaciteEnglish;

    public TitreOfMarin(String numeroDuTitre, String name, String delivranceDate, String revalidationDate,
                        String effetDate, String expirationDate, String isValid, String autoriteDeDelivrance,
                        List<String> restrictionsInStandardFormat, List<String> restrictionsInStandardFormatEnglish,
                        List<String> restrictionInFreeFormat, List<String> restrictionInFreeFormatEnglish,
                        String capacite, String capaciteEnglish) {
        this.numeroDuTitre = numeroDuTitre;
        this.name = name;
        this.delivranceDate = delivranceDate;
        this.revalidationDate = revalidationDate;
        this.effetDate = effetDate;
        this.expirationDate = expirationDate;
        this.isValid = isValid;
        this.autoriteDeDelivrance = autoriteDeDelivrance;
        this.restrictionsInStandardFormat = restrictionsInStandardFormat;
        this.restrictionsInStandardFormatEnglish = restrictionsInStandardFormatEnglish;
        this.restrictionInFreeFormat = restrictionInFreeFormat;
        this.restrictionInFreeFormatEnglish = restrictionInFreeFormatEnglish;
        this.capacite = capacite;
        this.capaciteEnglish = capaciteEnglish;
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

    public List<String> getRestrictionsInStandardFormat() {
        return restrictionsInStandardFormat;
    }

    public List<String> getRestrictionsInStandardFormatEnglish() {
        return restrictionsInStandardFormatEnglish;
    }

    public List<String> getRestrictionInFreeFormat() {
        return restrictionInFreeFormat;
    }

    public List<String> getRestrictionInFreeFormatEnglish() {
        return restrictionInFreeFormatEnglish;
    }

    public String getCapacite() {
        return capacite;
    }

    public String getCapaciteEnglish() {
        return capaciteEnglish;
    }
}
