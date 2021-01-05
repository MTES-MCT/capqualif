package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.List;

public class Key {
    private String keyCategory;
    private String keyName;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public Key(String keyCategory, String keyName) {
        this.keyCategory = keyCategory;
        this.keyName = keyName;
    }

    public Key(String keyCategory, String keyName, boolean isNested, List<ParentKey> parentKeys) {
        this.keyCategory = keyCategory;
        this.keyName = keyName;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getKeyCategory() {
        return keyCategory;
    }

    public String getKeyName() {
        return keyName;
    }

    public boolean isNested() {
        return isNested;
    }

    public List<ParentKey> getParentKeys() {
        return parentKeys;
    }
}
