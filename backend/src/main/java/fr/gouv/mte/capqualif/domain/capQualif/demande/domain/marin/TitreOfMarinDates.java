package fr.gouv.mte.capqualif.domain.capQualif.demande.domain.marin;

public class TitreOfMarinDates {
    private String delivranceDate;
    private String revalidationDate;
    private String effetDate;
    private String expirationDate;

    public TitreOfMarinDates(String delivranceDate, String revalidationDate, String effetDate, String expirationDate) {
        this.delivranceDate = delivranceDate;
        this.revalidationDate = revalidationDate;
        this.effetDate = effetDate;
        this.expirationDate = expirationDate;
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
}
