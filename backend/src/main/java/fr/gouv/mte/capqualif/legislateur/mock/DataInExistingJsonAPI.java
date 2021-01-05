package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.List;

public class DataInExistingJsonAPI {
    private String source;
    private String url;
    private Key mainWantedKey;
    private List<Key> additionalWantedKeys;

    public DataInExistingJsonAPI(String source, String url, Key mainWantedKey,
                                 List<Key> additionalWantedKeys) {
        this.source = source;
        this.url = url;
        this.mainWantedKey = mainWantedKey;
        this.additionalWantedKeys = additionalWantedKeys;
    }

    public DataInExistingJsonAPI(String source, String url, Key mainWantedKey) {
        this.source = source;
        this.url = url;
        this.mainWantedKey = mainWantedKey;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public Key getMainWantedKey() {
        return mainWantedKey;
    }

    public List<Key> getAdditionalWantedKeys() {
        return additionalWantedKeys;
    }
}