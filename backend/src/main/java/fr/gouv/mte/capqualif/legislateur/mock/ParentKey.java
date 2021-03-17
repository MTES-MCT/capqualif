package fr.gouv.mte.capqualif.legislateur.mock;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ParentKey parentKey = (ParentKey) o;
        return position == parentKey.position &&
                keyName.equals(parentKey.keyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, keyName);
    }
}