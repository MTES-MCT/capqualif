package fr.gouv.mte.capqualif.legislateur.mock;

public class Key {
    private String keyName;
    private String keyValue;
    private boolean isNested;
    private String parentKeyName;

    public Key(String keyName, String keyValue) {
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public Key(String keyName, String keyValue, boolean isNested, String parentKeyName) {
        this.keyName = keyName;
        this.keyValue = keyValue;
        this.isNested = isNested;
        this.parentKeyName = parentKeyName;
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

    public String getParentKeyName() {
        return parentKeyName;
    }
}
