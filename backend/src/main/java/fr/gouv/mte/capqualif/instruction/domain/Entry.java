package fr.gouv.mte.capqualif.instruction.domain;

import fr.gouv.mte.capqualif.titre.domain.Value;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Entry entry = (Entry) o;
        return key.equals(entry.key) &&
                value.equals(entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
