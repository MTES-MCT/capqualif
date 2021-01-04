package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.List;

public class ExistingDataInfos {
    private String source;
    private String url;
    private String mainWantedKey;
    private List<Key> additionalWantedKeys;

    public ExistingDataInfos(String source, String url, String mainWantedKey,
                             List<Key> additionalWantedKeys) {
        this.source = source;
        this.url = url;
        this.mainWantedKey = mainWantedKey;
        this.additionalWantedKeys = additionalWantedKeys;
    }

    public ExistingDataInfos(String source, String url, String mainWantedKey) {
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

    public String getMainWantedKey() {
        return mainWantedKey;
    }

    public List<Key> getAdditionalWantedKeys() {
        return additionalWantedKeys;
    }
}