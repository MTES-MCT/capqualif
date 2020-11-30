package fr.gouv.mte.capqualif.title.domain;

public class ConditionAttestation implements ConditionEducation {

    private String libelle;
    private Module module;

    @Override
    public boolean checkValidity() {
        // dateFinValidite ok
        return false;
    }
}
