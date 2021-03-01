package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

import java.util.Objects;

public class EntryInExistingDataSource {
    private KeyInExistingDataSource keyInExistingDataSource;
    private Value value;
    private DataType dataType;

    public EntryInExistingDataSource(KeyInExistingDataSource keyInExistingDataSource, Value value, DataType dataType) {
        this.keyInExistingDataSource = keyInExistingDataSource;
        this.value = value;
        this.dataType = dataType;
    }

    public KeyInExistingDataSource getKeyInExistingDataSource() {
        return keyInExistingDataSource;
    }

    public Value getValue() {
        return value;
    }

    public DataType getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        return "EntryInExistingDataSource{" +
                "keyInExistingDataSource=" + keyInExistingDataSource +
                ", value=" + value +
                ", dataType=" + dataType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EntryInExistingDataSource that = (EntryInExistingDataSource) o;
        return keyInExistingDataSource.equals(that.keyInExistingDataSource) &&
                Objects.equals(value, that.value) &&
                dataType == that.dataType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyInExistingDataSource, value, dataType);
    }
}
