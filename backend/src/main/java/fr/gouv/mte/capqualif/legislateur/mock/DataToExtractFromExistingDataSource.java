package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;
import java.util.Objects;

public class DataToExtractFromExistingDataSource {
    private String juridicalDesignation;
    private ExistingDataSourceName APIName;
    private String APIUrl;
    private EntryInExistingDataSource entryToSearchFor;
    private List<KeyInExistingDataSource> keysOfAdditionalWantedData;

    public DataToExtractFromExistingDataSource(String juridicalDesignation, ExistingDataSourceName APIName,
                                               String APIUrl, EntryInExistingDataSource entryToSearchFor,
                                               List<KeyInExistingDataSource> keysOfAdditionalWantedData) {
        this.juridicalDesignation = juridicalDesignation;
        this.APIName = APIName;
        this.APIUrl = APIUrl;
        this.entryToSearchFor = entryToSearchFor;
        this.keysOfAdditionalWantedData = keysOfAdditionalWantedData;
    }

    public String getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public ExistingDataSourceName getAPIName() {
        return APIName;
    }

    public String getAPIUrl() {
        return APIUrl;
    }

    public EntryInExistingDataSource getEntryToSearchFor() {
        return entryToSearchFor;
    }

    public List<KeyInExistingDataSource> getKeysOfAdditionalWantedData() {
        return keysOfAdditionalWantedData;
    }

    @Override
    public String toString() {
        return "DataToExtractFromExistingDataSource{" +
                "juridicalDesignation='" + juridicalDesignation + '\'' +
                ", APIName=" + APIName +
                ", APIUrl='" + APIUrl + '\'' +
                ", entryToSearchFor=" + entryToSearchFor +
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
        return juridicalDesignation.equals(that.juridicalDesignation) &&
                APIName == that.APIName &&
                APIUrl.equals(that.APIUrl) &&
                entryToSearchFor.equals(that.entryToSearchFor) &&
                Objects.equals(keysOfAdditionalWantedData, that.keysOfAdditionalWantedData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(juridicalDesignation, APIName, APIUrl, entryToSearchFor, keysOfAdditionalWantedData);
    }
}