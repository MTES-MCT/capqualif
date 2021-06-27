package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class Data<T> {

    private final String juridicalDesignation;
    private final T value;

    public Data(String juridicalDesignation, T value) {
        this.juridicalDesignation = juridicalDesignation;
        this.value = value;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public T getValue() {
        return value;
    }
}