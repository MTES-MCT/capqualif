package fr.gouv.mte.capqualif.sailor.domain;

import java.util.List;

public class SailorEducationData {
    private List<titreMarin> titres;

    public SailorEducationData(List<titreMarin> titres) {
        this.titres = titres;
    }

    public List<titreMarin> getTitles() {
        return titres;
    }
}