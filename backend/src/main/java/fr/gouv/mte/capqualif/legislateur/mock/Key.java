package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.List;

public class Key {
    private String keyGenericName;
    private String keyRealNameInExistingDataSource;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public Key(String keyGenericName, String keyRealNameInExistingDataSource) {
        this.keyGenericName = keyGenericName;
        this.keyRealNameInExistingDataSource = keyRealNameInExistingDataSource;
    }

    public Key(String keyGenericName, String keyRealNameInExistingDataSource, boolean isNested, List<ParentKey> parentKeys) {
        this.keyGenericName = keyGenericName;
        this.keyRealNameInExistingDataSource = keyRealNameInExistingDataSource;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getKeyGenericName() {
        return keyGenericName;
    }

    public String getKeyRealNameInExistingDataSource() {
        return keyRealNameInExistingDataSource;
    }

    public boolean isNested() {
        return isNested;
    }

    public List<ParentKey> getParentKeys() {
        return parentKeys;
    }
}
