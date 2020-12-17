package fr.gouv.mte.capqualif.titre.domain;

import java.util.List;

public class Titre {

    private String id;
    private String titleName;
    private List<String> criteria;
    private List<String> prerogatives;


    public Titre(String id, String libelle, List<ConditionTitre> conditions, List<String> restrictions) {
        this.id = id;
        this.titleName = titleName;
        this.criteria = criteria;
        this.prerogatives = prerogatives;
    }

    public String getId() {
        return id;
    }

    public String getTitleName() {
        return titleName;
    }

    public List<String> getCriteria() {
        return criteria;
    }

    public List<String> getPrerogatives() {
        return prerogatives;
    }
}