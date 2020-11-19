package fr.gouv.mte.capqualif.title.domain;

import java.util.List;

public class Title {

    private String id;
    private String titleName;
    private List<String> criteria;
    private List<String> prerogatives;

    public Title(String id, String titleName, List<String> criteria, List<String> prerogatives) {
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