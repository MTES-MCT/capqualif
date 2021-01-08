package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

import java.util.List;

public class Key {
    private String keyRealNameInExistingDataSource;
    private DataType typeOfAssociatedValue;
    private boolean isNested;
    private List<ParentKey> parentKeys;

    public Key(String keyRealNameInExistingDataSource, DataType typeOfAssociatedValue) {
        this.keyRealNameInExistingDataSource = keyRealNameInExistingDataSource;
        this.typeOfAssociatedValue = typeOfAssociatedValue;
    }

    public Key(String keyRealNameInExistingDataSource, DataType typeOfAssociatedValue, boolean isNested,
               List<ParentKey> parentKeys) {
        this.keyRealNameInExistingDataSource = keyRealNameInExistingDataSource;
        this.typeOfAssociatedValue = typeOfAssociatedValue;
        this.isNested = isNested;
        this.parentKeys = parentKeys;
    }

    public String getKeyRealNameInExistingDataSource() {
        return keyRealNameInExistingDataSource;
    }

    public DataType getTypeOfAssociatedValue() {
        return typeOfAssociatedValue;
    }

    public boolean isNested() {
        return isNested;
    }

    public List<ParentKey> getParentKeys() {
        return parentKeys;
    }
}
