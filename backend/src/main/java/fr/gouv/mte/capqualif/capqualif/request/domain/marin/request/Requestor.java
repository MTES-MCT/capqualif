package fr.gouv.mte.capqualif.capqualif.request.domain.marin.request;

public class Requestor {
    public String numeroDeMarin;
    public String firstName;
    public String lastName;

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