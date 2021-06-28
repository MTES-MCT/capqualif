package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

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