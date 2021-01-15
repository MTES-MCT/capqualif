package fr.gouv.mte.capqualif.marin.domain.marin;

public class Restriction {

    private String restrictionsInStandardFormat;
    private String restrictionsInStandardFormatEnglish;

    private String restrictionInFreeFormat;
    private String restrictionInFreeFormatEnglish;

    public Restriction(String restrictionsInStandardFormat, String restrictionsInStandardFormatEnglish,
                       String restrictionInFreeFormat, String restrictionInFreeFormatEnglish) {
        this.restrictionsInStandardFormat = restrictionsInStandardFormat;
        this.restrictionsInStandardFormatEnglish = restrictionsInStandardFormatEnglish;
        this.restrictionInFreeFormat = restrictionInFreeFormat;
        this.restrictionInFreeFormatEnglish = restrictionInFreeFormatEnglish;
    }

    public void setRestrictionsInStandardFormat(String restrictionsInStandardFormat) {
        this.restrictionsInStandardFormat = restrictionsInStandardFormat;
    }

    public void setRestrictionsInStandardFormatEnglish(String restrictionsInStandardFormatEnglish) {
        this.restrictionsInStandardFormatEnglish = restrictionsInStandardFormatEnglish;
    }

    public void setRestrictionInFreeFormat(String restrictionInFreeFormat) {
        this.restrictionInFreeFormat = restrictionInFreeFormat;
    }

    public void setRestrictionInFreeFormatEnglish(String restrictionInFreeFormatEnglish) {
        this.restrictionInFreeFormatEnglish = restrictionInFreeFormatEnglish;
    }
}
