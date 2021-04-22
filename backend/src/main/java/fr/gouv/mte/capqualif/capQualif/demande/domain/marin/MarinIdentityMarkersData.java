package fr.gouv.mte.capqualif.capQualif.demande.domain.marin;

public class MarinIdentityMarkersData {
    private String photo;           // cette info n'est pas récupérable par API ADM
    private String signature;       // cette info n'est pas récupérable par API ADM

    public MarinIdentityMarkersData(String photo, String signature) {
        this.photo = photo;
        this.signature = signature;
    }

    public String getPhoto() {
        return photo;
    }

    public String getSignature() {
        return signature;
    }
}
