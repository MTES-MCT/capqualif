package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.instruction.domain.Entry;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;

public class DataToExtractFromExistingDataSource {
    private ExistingDataSourceName APIName;
    private String APIUrl;
    private Entry entryToSearchFor;
    private List<KeyInExistingDataSource> keysOfAdditionalWantedData;

    public DataToExtractFromExistingDataSource(ExistingDataSourceName APIName, String APIUrl, Entry entryToSearchFor,
                                               List<KeyInExistingDataSource> keysOfAdditionalWantedData) {
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.entryToSearchFor = entryToSearchFor;
        this.keysOfAdditionalWantedData = keysOfAdditionalWantedData;
    }

    public ExistingDataSourceName getAPIName() {
        return APIName;
    }

    public String getAPIUrl() {
        return APIUrl;
    }

    public Entry getEntryToSearchFor() {
        return entryToSearchFor;
    }

    public List<KeyInExistingDataSource> getKeysOfAdditionalWantedData() {
        return keysOfAdditionalWantedData;
    }
}