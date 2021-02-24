package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

import java.util.List;
import java.util.Objects;

public class KeyInExistingDataSource {
    private String key;
    private DataType dataType;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public KeyInExistingDataSource(String key, DataType dataType) {
        this.key = key;
        this.dataType = dataType;
    }

    public KeyInExistingDataSource(String key, DataType dataType, boolean isNested, List<ParentKey> parentKeys) {
        this.key = key;
        this.dataType = dataType;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getKey() {
        return key;
    }

    public DataType getDataType() {
        return dataType;
    }

    public boolean isNested() {
        return isNested;
    }

    public List<ParentKey> getParentKeys() {
        return parentKeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        KeyInExistingDataSource that = (KeyInExistingDataSource) o;
        return isNested == that.isNested &&
                key.equals(that.key) &&
                dataType == that.dataType &&
                Objects.equals(parentKeys, that.parentKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, dataType, isNested, parentKeys);
    }

    @Override
    public String toString() {
        return "KeyInExistingDataSource{" +
                "key='" + key + '\'' +
                ", dataType=" + dataType +
                ", isNested=" + isNested +
                ", parentKeys=" + parentKeys +
                '}';
    }
}
