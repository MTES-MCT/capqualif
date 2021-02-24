package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;

public class DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue extends DataToExtractFromExistingDataSource {

    private EntryInExistingDataSource entryInExistingDataSourceOfMainWantedData;


    public DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(ExistingDataSourceName APIName,
                                                                         String APIUrl,
                                                                         List<KeyInExistingDataSource> keysOfAdditionalWantedData,
                                                                         EntryInExistingDataSource entryInExistingDataSourceOfMainWantedData) {
        super(APIName, APIUrl, keysOfAdditionalWantedData);
        this.entryInExistingDataSourceOfMainWantedData = entryInExistingDataSourceOfMainWantedData;
    }

    public DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(ExistingDataSourceName APIName,
                                                                         String APIUrl,
                                                                         EntryInExistingDataSource entryInExistingDataSourceOfMainWantedData) {
        super(APIName, APIUrl);
        this.entryInExistingDataSourceOfMainWantedData = entryInExistingDataSourceOfMainWantedData;
    }

    public EntryInExistingDataSource getEntryInExistingDataSourceOfMainWantedData() {
        return entryInExistingDataSourceOfMainWantedData;
    }
}
