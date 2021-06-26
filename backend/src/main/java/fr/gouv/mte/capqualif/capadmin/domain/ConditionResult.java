package fr.gouv.mte.capqualif.capadmin.domain;

public class ConditionResult {
    private String name;
    private String group;
    private Boolean result;

    public ConditionResult(String name, String group, Boolean result) {
        this.name = name;
        this.group = group;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Boolean getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ConditionResult{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", result=" + result +
                '}';
    }
}
