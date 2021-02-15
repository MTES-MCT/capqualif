package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;

public class DataToExtractFromExistingDataSource {
    private ExistingDataSourceName APIName;
    private String APIUrl;
    private KeyInExistingDataSource keyInExistingDataSourceOfMainWantedData;
    private List<KeyInExistingDataSource> keysOfAdditionnalWantedData;

    public DataToExtractFromExistingDataSource(ExistingDataSourceName APIName, String APIUrl, KeyInExistingDataSource keyInExistingDataSourceOfMainWantedData,
                                               List<KeyInExistingDataSource> keysOfAdditionnalWantedData) {
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.keyInExistingDataSourceOfMainWantedData = keyInExistingDataSourceOfMainWantedData;
        this.keysOfAdditionnalWantedData = keysOfAdditionnalWantedData;
    }

    public DataToExtractFromExistingDataSource(ExistingDataSourceName APIName, String APIUrl, KeyInExistingDataSource keyInExistingDataSourceOfMainWantedData) {
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.keyInExistingDataSourceOfMainWantedData = keyInExistingDataSourceOfMainWantedData;
    }

    public ExistingDataSourceName getAPIName() {
        return APIName;
    }

    public String getAPIUrl() {
        return APIUrl;
    }

    public KeyInExistingDataSource getKeyOfMainWantedData() {
        return keyInExistingDataSourceOfMainWantedData;
    }

    public List<KeyInExistingDataSource> getKeysOfAdditionnalWantedData() {
        return keysOfAdditionnalWantedData;
    }
}