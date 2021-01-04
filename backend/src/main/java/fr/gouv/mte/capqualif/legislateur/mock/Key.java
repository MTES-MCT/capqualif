package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.List;

public class Key {
    private String keyName;
    private String keyValue;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public Key(String keyName, String keyValue) {
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public Key(String keyName, String keyValue, boolean isNested, List<ParentKey> parentKeys) {
        this.keyName = keyName;
        this.keyValue = keyValue;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public boolean isNested() {
        return isNested;
    }

    public List<ParentKey> getParentKeys() {
        return parentKeys;
    }
}
