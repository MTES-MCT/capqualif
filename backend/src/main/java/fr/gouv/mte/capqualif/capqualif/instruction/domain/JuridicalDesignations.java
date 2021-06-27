package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public enum JuridicalDesignations {

    AGE("âge"),
    APTITUDE_MEDICALE("aptitude médicale"),
    FORMATIONS("formations"),
    TITRES("titres");

    private String juridicalDesignation;

    JuridicalDesignations(String juridicalDesignation) {
        this.juridicalDesignation = juridicalDesignation;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }
}
