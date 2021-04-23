package fr.gouv.mte.capqualif.capAdmin.adapters.out.mock;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.enums.DataType;

import java.util.Objects;

public class EntryInExistingDataSource {
    private KeyInExistingDataSource keyInExistingDataSource;
    private ValueInExistingDataSource valueInExistingDataSource;
    private DataType dataType;

    public EntryInExistingDataSource(KeyInExistingDataSource keyInExistingDataSource, ValueInExistingDataSource valueInExistingDataSource, DataType dataType) {
        this.keyInExistingDataSource = keyInExistingDataSource;
        this.valueInExistingDataSource = valueInExistingDataSource;
        this.dataType = dataType;
    }

    public KeyInExistingDataSource getKeyInExistingDataSource() {
        return keyInExistingDataSource;
    }

    public ValueInExistingDataSource getValueInExistingDataSource() {
        return valueInExistingDataSource;
    }

    public DataType getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        return "EntryInExistingDataSource{" +
                "keyInExistingDataSource=" + keyInExistingDataSource +
                ", valueInExistingDataSource=" + valueInExistingDataSource +
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
                Objects.equals(valueInExistingDataSource, that.valueInExistingDataSource) &&
                dataType == that.dataType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyInExistingDataSource, valueInExistingDataSource, dataType);
    }
}
