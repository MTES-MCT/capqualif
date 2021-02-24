package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

import java.util.List;

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
}
