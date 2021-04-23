package fr.gouv.mte.capqualif.capAdmin.titreTemp.domain;

import java.util.List;

public class Titre {

    private String id;
    private String libelle;
    private List<ConditionTitre> conditions;
    private List<String> restrictions;

    public Titre(String id, String libelle, List<ConditionTitre> conditions, List<String> restrictions) {
        this.id = id;
        this.libelle = libelle;
        this.conditions = conditions;
        this.restrictions = restrictions;
    }

    public String getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<ConditionTitre> getConditions() {
        return conditions;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }
}