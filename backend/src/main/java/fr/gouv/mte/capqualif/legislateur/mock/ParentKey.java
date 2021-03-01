package fr.gouv.mte.capqualif.legislateur.mock;

public class ParentKey {
    private Position position;
    private String keyName;

    public ParentKey(Position position, String keyName) {
        this.position = position;
        this.keyName = keyName;
    }

    public Position getPosition() {
        return position;
    }

    public String getKeyName() {
        return keyName;
    }

    @Override
    public String toString() {
        return "ParentKey{" +
                "position=" + position +
                ", keyName='" + keyName + '\'' +
                '}';
    }
}