package fr.gouv.mte.capqualif.capAdmin.domain;

import java.util.Objects;

public class Group {
    String name;
    Operator operator;

    public Group(String name, Operator operator) {
        this.name = name;
        this.operator = operator;
    }

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    public String getName() {
        return name;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", operator=" + operator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Group group = (Group) o;
        return name.equals(group.name) &&
                operator == group.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operator);
    }
}
