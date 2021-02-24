package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

import java.util.Objects;

public class Value {
    private String content;
    private DataType type;

    public Value(String content, DataType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public DataType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Value{" +
                "content='" + content + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Value value = (Value) o;
        return content.equals(value.content) &&
                type == value.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, type);
    }
}
