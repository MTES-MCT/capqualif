package fr.gouv.mte.capqualif.marin.domain;

public class SailorIdentityMarkersData {
    private String photo;           // cette info n'est pas récupérable par API ADM
    private String signature;       // cette info n'est pas récupérable par API ADM

    public SailorIdentityMarkersData(String photo, String signature) {
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
