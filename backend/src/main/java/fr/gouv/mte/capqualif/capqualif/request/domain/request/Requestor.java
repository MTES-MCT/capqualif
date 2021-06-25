package fr.gouv.mte.capqualif.capqualif.request.domain.request;

public class Requestor {
    private String numeroDeMarin;
    private String firstName;
    private String lastName;

    public String getNumeroDeMarin() {
        return numeroDeMarin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Requestor{" +
                "numeroDeMarin='" + numeroDeMarin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}