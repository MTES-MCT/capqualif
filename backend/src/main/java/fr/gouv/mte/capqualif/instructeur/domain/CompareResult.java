package fr.gouv.mte.capqualif.instructeur.domain;

import java.util.List;

public class CompareResult {

    private String label;
    private boolean estValide;

    public CompareResult(String label, boolean estValide) {
        this.label = label;
        this.estValide = estValide;
    }

    public String getLabel() {
        return label;
    }

    public boolean isEstValide() {
        return estValide;
    }
}
