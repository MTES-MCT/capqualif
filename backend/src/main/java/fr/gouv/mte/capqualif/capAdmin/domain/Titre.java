package fr.gouv.mte.capqualif.capAdmin.domain;

import java.util.List;
import java.util.Objects;

public class Titre {
    private String name;
    private List<Condition> conditions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Titre{" +
                "name='" + name + '\'' +
                ", conditions=" + conditions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Titre titre = (Titre) o;
        return name.equals(titre.name) &&
                conditions.equals(titre.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, conditions);
    }
}
