package fr.gouv.mte.capqualif.titre.domain;

import fr.gouv.mte.capqualif.titre.domain.enums.ValueType;

public class Value {
    private String content;
    private ValueType type;

    public Value(String content, ValueType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public ValueType getType() {
        return type;
    }
}
