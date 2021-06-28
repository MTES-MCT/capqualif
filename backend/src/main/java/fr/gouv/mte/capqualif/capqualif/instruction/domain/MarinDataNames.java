package fr.gouv.mte.capqualif.capqualif.instruction.domain;

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
