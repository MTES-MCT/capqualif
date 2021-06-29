package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.List;
import java.util.Objects;

public class GlobalResult {

    private String titre;
    private final boolean conditionsSatisfied;
    private final List<ConditionResult> details;

    public GlobalResult(String titre, boolean conditionsSatisfied, List<ConditionResult> details) {
        this.titre = titre;
        this.conditionsSatisfied = conditionsSatisfied;
        this.details = details;
    }

    public boolean areConditionsSatisfied() {
        return conditionsSatisfied;
    }

    public List<ConditionResult> getDetails() {
        return details;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GlobalResult that = (GlobalResult) o;
        return conditionsSatisfied == that.conditionsSatisfied &&
                Objects.equals(titre, that.titre) &&
                Objects.equals(details, that.details);
    }

    @Override
    public String toString() {
        return "GlobalResult{" +
                "titre='" + titre + '\'' +
                ", conditionsSatisfied=" + conditionsSatisfied +
                ", details=" + details +
                '}';
    }
}