package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.List;
import java.util.Objects;

public class PossibleTitre {

    private String titre;
    private final boolean finalResult;
    private final List<ConditionResult> details;

    public PossibleTitre(String titre, boolean finalResult, List<ConditionResult> details) {
        this.titre = titre;
        this.finalResult = finalResult;
        this.details = details;
    }

    public boolean areConditionsSatisfied() {
        return finalResult;
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
        PossibleTitre that = (PossibleTitre) o;
        return finalResult == that.finalResult &&
                Objects.equals(titre, that.titre) &&
                Objects.equals(details, that.details);
    }

    @Override
    public String toString() {
        return "PossibleTitre{" +
                "titre='" + titre + '\'' +
                ", finalResult=" + finalResult +
                ", details=" + details +
                '}';
    }
}