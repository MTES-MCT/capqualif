package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public enum JuridicalDesignations {

    AGE("age"),
    APTITUDE_MEDICALE("aptitude"),
    FORMATIONS("formations"),
    TITRES("titres");

    private final String name;

    JuridicalDesignations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
