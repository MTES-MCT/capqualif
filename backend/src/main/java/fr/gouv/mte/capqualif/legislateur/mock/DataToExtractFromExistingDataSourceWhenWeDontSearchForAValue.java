package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;

public class DataToExtractFromExistingDataSourceWhenWeDontSearchForAValue extends DataToExtractFromExistingDataSource {

    private KeyInExistingDataSource keyInExistingDataSource;

    public DataToExtractFromExistingDataSourceWhenWeDontSearchForAValue(ExistingDataSourceName APIName,
                                                                        String APIUrl,
                                                                        List<KeyInExistingDataSource> keysOfAdditionalWantedData,
                                                                        KeyInExistingDataSource keyInExistingDataSource) {
        super(APIName, APIUrl, keysOfAdditionalWantedData);
        this.keyInExistingDataSource = keyInExistingDataSource;
    }

    public DataToExtractFromExistingDataSourceWhenWeDontSearchForAValue(ExistingDataSourceName APIName, String APIUrl
            , KeyInExistingDataSource keyInExistingDataSource) {
        super(APIName, APIUrl);
        this.keyInExistingDataSource = keyInExistingDataSource;
    }

    public KeyInExistingDataSource getKeyInExistingDataSource() {
        return keyInExistingDataSource;
    }
}
