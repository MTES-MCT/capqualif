package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.Value;

import java.util.List;
import java.util.Objects;

public class EntryInExistingDataSource {
    private KeyInExistingDataSource key;
    private Value value;

    public EntryInExistingDataSource(KeyInExistingDataSource key, Value value) {
        this.key = key;
        this.value = value;
    }

    public KeyInExistingDataSource getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EntryInExistingDataSource{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EntryInExistingDataSource that = (EntryInExistingDataSource) o;
        return key.equals(that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
