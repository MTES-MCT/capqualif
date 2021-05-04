package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.Objects;

public class ConditionIdentity {
    private String name;
    private Group group;

    public ConditionIdentity(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ConditionIdentity{" +
                "name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ConditionIdentity that = (ConditionIdentity) o;
        return name.equals(that.name) &&
                group.equals(that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}
