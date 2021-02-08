package fr.gouv.mte.capqualif.marin.domain.marin;

import java.util.List;

public class TitreOfMarin {

    private final String id;
    private final String numeroOfTitre;
    private final String name;
    private final TitreOfMarinDates dates;
    private final String capacite;
    private final String capaciteEnglish;
    private final String validityStatus;
    private final String autoriteDeDelivrance;
    private final List<String> restrictionsInStandardFormat;
    private final List<String> restrictionsInStandardFormatEnglish;
    private final List<String> restrictionInFreeFormat;
    private final List<String> restrictionInFreeFormatEnglish;

    public TitreOfMarin(String id, String numeroOfTitre, String name, TitreOfMarinDates dates, String capacite, String capaciteEnglish, String validityStatus, String autoriteDeDelivrance, List<String> restrictionsInStandardFormat, List<String> restrictionsInStandardFormatEnglish, List<String> restrictionInFreeFormat, List<String> restrictionInFreeFormatEnglish) {
        this.id = id;
        this.numeroOfTitre = numeroOfTitre;
        this.name = name;
        this.dates = dates;
        this.capacite = capacite;
        this.capaciteEnglish = capaciteEnglish;
        this.validityStatus = validityStatus;
        this.autoriteDeDelivrance = autoriteDeDelivrance;
        this.restrictionsInStandardFormat = restrictionsInStandardFormat;
        this.restrictionsInStandardFormatEnglish = restrictionsInStandardFormatEnglish;
        this.restrictionInFreeFormat = restrictionInFreeFormat;
        this.restrictionInFreeFormatEnglish = restrictionInFreeFormatEnglish;
    }

    public String getId() {
        return id;
    }

    public String getNumeroOfTitre() {
        return numeroOfTitre;
    }

    public String getName() {
        return name;
    }

    public TitreOfMarinDates getDates() {
        return dates;
    }

    public String getCapacite() {
        return capacite;
    }

    public String getCapaciteEnglish() {
        return capaciteEnglish;
    }

    public String getValidityStatus() {
        return validityStatus;
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
}
