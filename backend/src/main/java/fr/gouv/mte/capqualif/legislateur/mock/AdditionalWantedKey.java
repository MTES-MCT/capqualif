package fr.gouv.mte.capqualif.legislateur.mock;

public class AdditionalWantedKey {
    private String keyName;
    private String keyValue;

    public AdditionalWantedKey(String keyName, String keyValue) {
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }
}
