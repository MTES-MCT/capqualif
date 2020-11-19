package fr.gouv.mte.capqualif.sailor.domain;

public class SailorCivilData {
    private String sailorNumber;      // numeroIdentification dans Objet IndividuDto (numIdentification dans doc API ADM)
    private String firstName;       // prénom dans Objet IndividuDto
    private String lastName;        // nom dans Objet IndividuDto
    private String dateOfBirth;       // date de naissance dans Objet IndividuDto
    private String placeOfBirth;    // lieu de naissance dans Objet IndividuDto
    private String address;         // adresse (AdresseDTO) dans Objet IndividuDto
    private String email;           // email dans ADM
//    private String phoneNumber;     // cette info n'est pas récupérable par API ADM


    public SailorCivilData(String sailorNumber, String firstName, String lastName, String dateOfBirth, String placeOfBirth, String address, String email) {
        this.sailorNumber = sailorNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.address = address;
        this.email = email;
    }

    public String getSailorNumber() {
        return sailorNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}