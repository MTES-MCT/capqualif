package fr.gouv.mte.capqualif.titre.domain;

public class Value {
    private String content;
    private String type;

    public Value(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }
}
