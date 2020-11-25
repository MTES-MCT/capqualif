package fr.gouv.mte.capqualif.sailor.domain;

public class Sailor {

    // [Numéro de marin] The official number
    private String sailorNumber;                                  // numeroIdentification dans Objet IndividuDto (numIdentification dans doc API ADM)

    // Civil data : birth date, address, phone number, email...
    private SailorCivilData sailorCivilData;

    // Identity markers : photo, signature...
    private SailorIdentityMarkersData sailorIdentityMarkersData;

    // Education : titles, visas...
    private SailorEducationData sailorEducationData;

    public Sailor(String sailorNumber, SailorCivilData sailorCivilData, SailorIdentityMarkersData sailorIdentityMarkersData, SailorEducationData sailorEducationData) {
        this.sailorNumber = sailorNumber;
        this.sailorCivilData = sailorCivilData;
        this.sailorIdentityMarkersData = sailorIdentityMarkersData;
        this.sailorEducationData = sailorEducationData;
    }

    public String getSailorNumber() {
        return sailorNumber;
    }

    public SailorCivilData getSailorCivilData() {
        return sailorCivilData;
    }

    public SailorIdentityMarkersData getSailorIdentityMarkersData() {
        return sailorIdentityMarkersData;
    }

    public SailorEducationData getSailorEducationData() {
        return sailorEducationData;
    }
}
