package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.List;

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
}
