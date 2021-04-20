package fr.gouv.mte.capqualif.legislateur.domain;

public class Data {
    private final String juridicalDesignation;
    private final String value;

    public Data(String juridicalDesignation, String value) {
        this.juridicalDesignation = juridicalDesignation;
        this.value = value;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public String getValue() {
        return value;
    }
}
