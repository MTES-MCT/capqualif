package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;
import java.util.Objects;

public class DataToExtractFromExistingDataSource {
    private ExistingDataSourceName APIName;
    private String APIUrl;
    private EntryInExistingDataSource mainWantedData;
    private List<KeyInExistingDataSource> keysOfAdditionalWantedData;

    public DataToExtractFromExistingDataSource(ExistingDataSourceName APIName, String APIUrl,
                                               EntryInExistingDataSource mainWantedData,
                                               List<KeyInExistingDataSource> keysOfAdditionalWantedData) {
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.mainWantedData = mainWantedData;
        this.keysOfAdditionalWantedData = keysOfAdditionalWantedData;
    }


    public ExistingDataSourceName getAPIName() {
        return APIName;
    }

    public String getAPIUrl() {
        return APIUrl;
    }

    public EntryInExistingDataSource getMainWantedData() {
        return mainWantedData;
    }

    public List<KeyInExistingDataSource> getKeysOfAdditionalWantedData() {
        return keysOfAdditionalWantedData;
    }

    @Override
    public String toString() {
        return "DataToExtractFromExistingDataSource{" +
                "APIName=" + APIName +
                ", APIUrl='" + APIUrl + '\'' +
                ", mainWantedData=" + mainWantedData +
                ", keysOfAdditionalWantedData=" + keysOfAdditionalWantedData +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DataToExtractFromExistingDataSource that = (DataToExtractFromExistingDataSource) o;
        return APIName == that.APIName &&
                APIUrl.equals(that.APIUrl) &&
                mainWantedData.equals(that.mainWantedData) &&
                Objects.equals(keysOfAdditionalWantedData, that.keysOfAdditionalWantedData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(APIName, APIUrl, mainWantedData, keysOfAdditionalWantedData);
    }
}