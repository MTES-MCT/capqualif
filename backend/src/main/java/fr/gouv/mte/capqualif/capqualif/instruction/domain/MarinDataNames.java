package fr.gouv.mte.capqualif.capqualif.instruction.domain;

/**
 * This values are used in the titre's conditions jsons. They are leftOpId values.
 */
public enum MarinDataNames {
    ADMINISTRES("age"),
    ESCULAPE("aptitude"),
    AMFORE("formations"),
    ITEM("titres");

    private final String name;

    MarinDataNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
