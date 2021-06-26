package fr.gouv.mte.capqualif.capadmin.domain;

public class ConditionResult {
    private String name;
    private Group group;
    private boolean result;

    public ConditionResult(String name, Group group, boolean result) {
        this.name = name;
        this.group = group;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public boolean isResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ConditionResult{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", result=" + result +
                '}';
    }
}
