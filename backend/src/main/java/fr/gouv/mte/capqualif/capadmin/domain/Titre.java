package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.List;
import java.util.Objects;

public class Titre {
    private String name;
    private List<Condition> conditions;

    public Titre() {
    }

    public Titre(String name, List<Condition> conditions) {
        this.name = name;
        this.conditions = conditions;
    }

    // This is a copy constructor. See http://www.javapractices.com/topic/TopicAction.do?Id=12.
    public Titre(Titre titre) {
        this(titre.getName(), titre.getConditions());
    }


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
