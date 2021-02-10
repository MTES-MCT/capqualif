package fr.gouv.mte.capqualif.legislateur.mock;

public class ParentKey {
    private Position position;
    private String keyRealNameInExistingDataSource;

    public ParentKey(Position position, String keyRealNameInExistingDataSource) {
        this.position = position;
        this.keyRealNameInExistingDataSource = keyRealNameInExistingDataSource;
    }

    public Position getPosition() {
        return position;
    }

    public String getKeyRealNameInExistingDataSource() {
        return keyRealNameInExistingDataSource;
    }

}