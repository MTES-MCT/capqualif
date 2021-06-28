package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class ItemDTO implements APIDataDTO {

    private String dateDelivrance;
    private String dateEffet;
    private String dateExpiration;
    private String libelle;

    public String getDateDelivrance() {
        return dateDelivrance;
    }

    public String getDateEffet() {
        return dateEffet;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "dateDelivrance='" + dateDelivrance + '\'' +
                ", dateEffet='" + dateEffet + '\'' +
                ", dateExpiration='" + dateExpiration + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}

class TitreState {
    private String code;
    private String libelle;

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return "TitreState{" +
                "code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
