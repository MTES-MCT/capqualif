package fr.gouv.mte.capqualif.marin.domain;

import java.util.List;

public class MarinEducationData {
    private List<titreMarin> titres;

    public MarinEducationData(List<titreMarin> titres) {
        this.titres = titres;
    }

    public List<titreMarin> getTitles() {
        return titres;
    }
}