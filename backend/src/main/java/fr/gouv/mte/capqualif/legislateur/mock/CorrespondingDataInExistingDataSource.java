package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;

import java.util.List;
import java.util.Objects;



public class CorrespondingDataInExistingDataSource {
    private ExistingDataSourceName APIName;
    private String APIUrl;
    private EntryInExistingDataSource mainWantedData;
    private List<KeyInExistingDataSource> keysOfAdditionalWantedData;

    /**
     *
     * @param APIName
     *              The name of the API used a data source
     * @param APIUrl
     *              The url of the API used a data source
     * @param mainWantedData
     *              Can be
     *                  1) an entry (key + value) (in case we are looking for a data that strictly matches a given value),
     *                  2) just a key (in case we do not have a precise value to use for comparison and just want to know what is the value of the key in the document).
     *              Real world example for case 1 : we want to know if the marin's aptitude médicale is "Apte TF/TN". So we're looking for the entry "libelle":"Apte TF/TN".
     *              Real world example for case 2 : we want to know the marin's birthdate to check if they is older than 18. So we're looking for the key to know they birthdate.
     * @param keysOfAdditionalWantedData
     *              Key of all data we need to confirm the validity of the mainWantedData.
     */
    public CorrespondingDataInExistingDataSource(ExistingDataSourceName APIName, String APIUrl,
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
        CorrespondingDataInExistingDataSource that = (CorrespondingDataInExistingDataSource) o;
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