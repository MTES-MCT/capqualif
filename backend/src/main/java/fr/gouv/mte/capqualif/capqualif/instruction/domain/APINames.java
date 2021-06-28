package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public enum APINames {
    ADMINISTRES("Administres"),
    ESCULAPE("Esculape"),
    AMFORE("Amfore"),
    ITEM("Item");

    private final String name;

    APINames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}