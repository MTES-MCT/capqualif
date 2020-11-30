package fr.gouv.mte.capqualif.sailor.domain;

import fr.gouv.mte.capqualif.sailor.domain.SailorTitle;

import java.util.List;

public class SailorEducationData {
    private List<SailorTitle> sailorTitles;
    //    TO DO : add private List<String> visas;

    public SailorEducationData(List<SailorTitle> sailorTitles) {
        this.sailorTitles = sailorTitles;
    }

    public List<SailorTitle> getTitles() {
        return sailorTitles;
    }
}