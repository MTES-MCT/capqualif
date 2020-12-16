package fr.gouv.mte.capqualif.title.domain;

public class ConditionTitre implements ConditionEducation {

    private String libelle;

    @Override
    public boolean checkValidity() {
        // "valide" + dateExpiration ok
        return false;
    }

}