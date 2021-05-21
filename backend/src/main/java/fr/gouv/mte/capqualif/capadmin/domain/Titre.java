package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.List;
import java.util.Objects;

public class Titre {
    private String titre;
    private List<Condition> conditions;

    public Titre() {
    }

    public Titre(String titre, List<Condition> conditions) {
        this.titre = titre;
        this.conditions = conditions;
    }

    // This is a copy constructor. See http://www.javapractices.com/topic/TopicAction.do?Id=12.
    public Titre(Titre titre) {
        this(titre.getTitre(), titre.getConditions());
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
                "name='" + titre + '\'' +
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
        return this.titre.equals(titre.titre) &&
                conditions.equals(titre.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, conditions);
    }
}
