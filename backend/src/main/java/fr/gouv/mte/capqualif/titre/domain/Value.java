package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;

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
}
