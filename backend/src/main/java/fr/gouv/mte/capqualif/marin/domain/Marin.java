package fr.gouv.mte.capqualif.marin.domain;

public class Marin {

    // [Numéro de marin] The official number
    private String numeroDeMarin;                                  // numeroIdentification dans Objet IndividuDto (numIdentification dans doc API ADM)

    // Civil data : birth date, address, phone number, email...
    private MarinCivilData marinCivilData;

    // Identity markers : photo, signature...
    private MarinIdentityMarkersData marinIdentityMarkersData;

    // Education : titles, visas...
    private MarinEducationData marinEducationData;

    public Marin(String numeroDeMarin, MarinCivilData marinCivilData, MarinIdentityMarkersData marinIdentityMarkersData, MarinEducationData marinEducationData) {
        this.numeroDeMarin = numeroDeMarin;
        this.marinCivilData = marinCivilData;
        this.marinIdentityMarkersData = marinIdentityMarkersData;
        this.marinEducationData = marinEducationData;
    }

    public String getNumeroDeMarin() {
        return numeroDeMarin;
    }

    public MarinCivilData getMarinCivilData() {
        return marinCivilData;
    }

    public MarinIdentityMarkersData getMarinIdentityMarkersData() {
        return marinIdentityMarkersData;
    }

    public MarinEducationData getMarinEducationData() {
        return marinEducationData;
    }
}
