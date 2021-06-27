package fr.gouv.mte.capqualif.capadmin.domain;

import java.util.Objects;

public class ConditionResult {
    private String name;
    private String group;
    private String marinData;
    private Boolean result;

    public ConditionResult(String name, String group, Boolean result) {
        this.name = name;
        this.group = group;
        this.result = result;
    }

    public ConditionResult(String name, String group, String marinData, Boolean result) {
        this.name = name;
        this.group = group;
        this.marinData = marinData;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getMarinData() {
        return marinData;
    }

    public Boolean getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ConditionResult{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", marinData='" + marinData + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ConditionResult that = (ConditionResult) o;
        return name.equals(that.name) &&
                group.equals(that.group) &&
                Objects.equals(marinData, that.marinData) &&
                result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, marinData, result);
    }
}
