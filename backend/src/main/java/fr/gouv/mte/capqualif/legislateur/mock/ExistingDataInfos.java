package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.List;

public class ExistingDataInfos {
    private String source;
    private String url;
    private String mainWantedKey;
    private List<AdditionalWantedKey> additionalWantedKeys;

    public ExistingDataInfos(String source, String url, String mainWantedKey,
                             List<AdditionalWantedKey> additionalWantedKeys) {
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

    public List<AdditionalWantedKey> getAdditionalWantedKeys() {
        return additionalWantedKeys;
    }
}