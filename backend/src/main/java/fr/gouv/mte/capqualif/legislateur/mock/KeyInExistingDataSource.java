package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

import java.util.List;
import java.util.Objects;

public class KeyInExistingDataSource {
    private String name;
    private DataType dataType;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public KeyInExistingDataSource(String name) {
        this.name = name;
    }

    public KeyInExistingDataSource(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public KeyInExistingDataSource(String name, boolean isNested, List<ParentKey> parentKeys) {
        this.name = name;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public KeyInExistingDataSource(String name, DataType dataType, boolean isNested, List<ParentKey> parentKeys) {
        this.name = name;
        this.dataType = dataType;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getName() {
        return name;
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
                name.equals(that.name) &&
                dataType == that.dataType &&
                Objects.equals(parentKeys, that.parentKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataType, isNested, parentKeys);
    }

    @Override
    public String toString() {
        return "KeyInExistingDataSource{" +
                "key='" + name + '\'' +
                ", dataType=" + dataType +
                ", isNested=" + isNested +
                ", parentKeys=" + parentKeys +
                '}';
    }
}
