package fr.gouv.mte.capqualif.legislateur.domain;

public enum OperationType {
    INTERMEDIATE("intermediate"),
    FINAL("final");

    private String typeValue;

    OperationType(String typeValue) {
        this.typeValue = typeValue;
    }
}
