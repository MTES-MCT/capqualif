package fr.gouv.mte.capqualif.instructeur.domain;

import fr.gouv.mte.capqualif.titre.domain.Value;

public class Entry {

    private String key;
    private Value value;

    public Entry(String key, Value value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
