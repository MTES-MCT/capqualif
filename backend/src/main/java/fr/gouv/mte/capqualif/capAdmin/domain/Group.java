package fr.gouv.mte.capqualif.capAdmin.domain;

public class Group {
    String name;
    Operator operator;

    public Group(String name, Operator operator) {
        this.name = name;
        this.operator = operator;
    }
}
