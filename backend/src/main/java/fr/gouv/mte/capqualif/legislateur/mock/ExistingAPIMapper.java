package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;

public class ExistingAPIMapper {
    private ExistingDataSourceName APIName;
    private String APIUrl;
    private Key keyOfMainWantedData;
    private List<Key> keysOfAdditionnalWantedData;

    public ExistingAPIMapper(ExistingDataSourceName APIName, String APIUrl, Key keyOfMainWantedData,
                             List<Key> KeysOfAdditionnalWantedData) {
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.keyOfMainWantedData = keyOfMainWantedData;
        this.keysOfAdditionnalWantedData = KeysOfAdditionnalWantedData;
    }

    public ExistingAPIMapper(ExistingDataSourceName APIName, String APIUrl, Key keyOfMainWantedData) {
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.keyOfMainWantedData = keyOfMainWantedData;
    }

    public ExistingDataSourceName getAPIName() {
        return APIName;
    }

    public String getAPIUrl() {
        return APIUrl;
    }

    public Key getKeyOfMainWantedData() {
        return keyOfMainWantedData;
    }

    public List<Key> getKeysOfAdditionnalWantedData() {
        return keysOfAdditionnalWantedData;
    }
}