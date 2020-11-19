package fr.gouv.mte.capqualif.sailor.domain;

import java.util.List;

public class SailorTitle {

    // To do : change String to Date where needed
    // Add fields from API St-Malo doc if needed

    private String id;
    private String titleName;
    private String titleNumber;
    private String deliveryDate;
    private String revalidationDate;
    private String effectDate;
    private String expirationDate;
    private List<String> restrictions;
//    private List<String> prerogatives;

    public SailorTitle(String id, String titleName, String titleNumber, String deliveryDate, String revalidationDate, String effectDate, String expirationDate, List<String> restrictions) {
        this.id = id;
        this.titleName = titleName;
        this.titleNumber = titleNumber;
        this.deliveryDate = deliveryDate;
        this.revalidationDate = revalidationDate;
        this.effectDate = effectDate;
        this.expirationDate = expirationDate;
        this.restrictions = restrictions;
    }

    public String getId() {
        return id;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getTitleNumber() {
        return titleNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getRevalidationDate() {
        return revalidationDate;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

}
