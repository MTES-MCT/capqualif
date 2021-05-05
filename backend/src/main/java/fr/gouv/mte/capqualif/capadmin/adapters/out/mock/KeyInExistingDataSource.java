package fr.gouv.mte.capqualif.capAdmin.adapters.out.mock;

import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.ComparisonData;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.ComparisonRule;
import fr.gouv.mte.capqualif.capAdmin.titreTemp.domain.enums.DataType;

import java.util.List;
import java.util.Objects;

public class KeyInExistingDataSource {
    private String juridicalName;
    private String realNameInExistingDataSource;
    private DataType dataType;
    private ComparisonRule comparisonRule;
    private ComparisonData comparisonReference;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public KeyInExistingDataSource(String juridicalName, String realNameInExistingDataSource, DataType dataType,
                                   ComparisonRule comparisonRule, ComparisonData comparisonReference) {
        this.juridicalName = juridicalName;
        this.realNameInExistingDataSource = realNameInExistingDataSource;
        this.dataType = dataType;
        this.comparisonRule = comparisonRule;
        this.comparisonReference = comparisonReference;
    }



    public KeyInExistingDataSource(String juridicalName, String realNameInExistingDataSource, DataType dataType,
                                   ComparisonRule comparisonRule, ComparisonData comparisonReference, boolean isNested,
                                   List<ParentKey> parentKeys) {
        this.juridicalName = juridicalName;
        this.realNameInExistingDataSource = realNameInExistingDataSource;
        this.dataType = dataType;
        this.comparisonRule = comparisonRule;
        this.comparisonReference = comparisonReference;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getJuridicalName() {
        return juridicalName;
    }

    public String getRealNameInExistingDataSource() {
        return realNameInExistingDataSource;
    }

    public DataType getDataType() {
        return dataType;
    }

    public ComparisonRule getComparisonRule() {
        return comparisonRule;
    }

    public ComparisonData getComparisonReference() {
        return comparisonReference;
    }

    public boolean isNested() {
        return isNested;
    }

    public List<ParentKey> getParentKeys() {
        return parentKeys;
    }

    @Override
    public String toString() {
        return "KeyInExistingDataSource{" +
                "juridicalName='" + juridicalName + '\'' +
                ", realNameInExistingDataSource='" + realNameInExistingDataSource + '\'' +
                ", dataType=" + dataType +
                ", comparisonRule=" + comparisonRule +
                ", referenceData=" + comparisonReference +
                ", isNested=" + isNested +
                ", parentKeys=" + parentKeys +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        KeyInExistingDataSource that = (KeyInExistingDataSource) o;
        return isNested == that.isNested &&
                juridicalName.equals(that.juridicalName) &&
                realNameInExistingDataSource.equals(that.realNameInExistingDataSource) &&
                dataType == that.dataType &&
                comparisonRule == that.comparisonRule &&
                Objects.equals(comparisonReference, that.comparisonReference) &&
                Objects.equals(parentKeys, that.parentKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(juridicalName, realNameInExistingDataSource, dataType, comparisonRule, comparisonReference, isNested, parentKeys);
    }
}
