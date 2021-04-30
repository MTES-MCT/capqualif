package fr.gouv.mte.capqualif.capAdmin.domain;

import fr.gouv.mte.capqualif.capAdmin.domain.temp.Marin;

import java.util.*;

public class Condition {

    private String name;
    private Group group;
    private String operator;
    private String leftOpId;
    private List<String> leftOpList;
    private String leftOp;
    private String rightOp;
    private List<Condition> subConditions;

    // Needed for deserialization
    public Condition() {
    }

    public Condition(String name, Group group, String operator, String leftOpId, List<String> leftOpList,
                     String leftOp, String rightOp, List<Condition> subConditions) {
        this.name = name;
        this.group = group;
        this.operator = operator;
        this.leftOpId = leftOpId;
        this.leftOpList = leftOpList;
        this.leftOp = leftOp;
        this.rightOp = rightOp;
        this.subConditions = subConditions;
    }

    public String getOperator() {
        return operator;
    }

    public List<String> getLeftOpList() {
        return leftOpList;
    }

    public void setLeftOpList(List<String> leftOpList) {
        this.leftOpList = leftOpList;
    }

    public String getLeftOp() {
        return leftOp;
    }

    public void setLeftOp(String leftOp) {
        this.leftOp = leftOp;
    }

    public String getRightOp() {
        return rightOp;
    }

    public List<Condition> getSubConditions() {
        return subConditions;
    }

    public String getName() {
        return name;
    }

    public String getLeftOpId() {
        return leftOpId;
    }

    public Group getGroup() {
        return group;
    }

    public void populateWithData(Marin marin) {
        for (Data<?> data : marin.getData()) {
            boolean done = false;
            replaceWithValue(data);
        }
    }

    public void replaceWithValue(Data<?> data) {
        if (data.getJuridicalDesignation().equals(leftOpId)) {
            replace(data);
        } else {
            if (subConditions != null) {
                for (Condition subcondition : subConditions) {
                    subcondition.replaceWithValue(data);
                }
            }
        }
    }

    private void replace(Data<?> data) {
        if (data.getValue() instanceof String) {
            setLeftOp((String) data.getValue());
        }
        if (data.getValue() instanceof List) {
            setLeftOpList((List<String>) data.getValue());
        }
    }

    private void replace(Condition condition, Data<?> data) {
        if (data.getValue() instanceof String) {
            condition.setLeftOp((String) data.getValue());
            System.out.println(condition.leftOp);
        }
        if (data.getValue() instanceof List) {
            condition.setLeftOpList((List<String>) data.getValue());
            System.out.println(condition.leftOpList);
        }
    }

    public boolean validate(List<ConditionIdentity> errorsList) {
        switch (operator) {
            case "AND":
                Map<ConditionIdentity, Boolean> andResults = new HashMap<>();
                if (subConditions != null) {
                    for (Condition subCondition : subConditions) {
                        boolean validationResult = subCondition.validate(errorsList);
                        andResults.put(buildConditionIdentity(subCondition.getName(), subCondition.getGroup().getName(), subCondition.getGroup().getOperator()), validationResult);
                    }
                }
                System.out.println("andResults : " + andResults);
                if (andResults.containsValue(Boolean.FALSE)) {
                    return false;
                }
                return true;
            case "OR":
                Map<ConditionIdentity, Boolean> orResults = new HashMap<>();
                if (subConditions != null) {
                    for (Condition subCondition : subConditions) {
                        boolean validationResult = subCondition.validate(errorsList);
                        orResults.put(buildConditionIdentity(subCondition.getName(), subCondition.getGroup().getName(), subCondition.getGroup().getOperator()), validationResult);
                    }
                }
                System.out.println("orResults : " + orResults);
                if (orResults.containsValue(Boolean.TRUE)) {
                    removeErrorsFromOtherFalseSubconditions(errorsList, orResults);
                    return true;
                }
                return false;
            case "==":
                if (leftOp.isEmpty() || !leftOp.equals(rightOp)) {
                    addToErrors(errorsList, name, group);
                    return false;
                }
                return true;
            case ">=":
                if (leftOp.isEmpty() || !(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    addToErrors(errorsList, name, group);
                    return false;
                }
                return true;
            case "contains":
                if (!leftOpList.contains(rightOp)) {
                    addToErrors(errorsList, name, group);
                    return false;
                }
                return true;
            default:
                System.out.println("validate aouch.");
                break;
        }
        System.out.println("Falling out of switch !");
        return false;
    }

    private ConditionIdentity buildConditionIdentity(String name, String groupName, Operator groupOperator) {
        return new ConditionIdentity(name, new Group(groupName, groupOperator));
    }

    private void addToErrors(List<ConditionIdentity> errorsList, String name, Group group) {
        errorsList.add(new ConditionIdentity(name, group));
    }

    private void removeErrorsFromOtherFalseSubconditions(List<ConditionIdentity> errorsList, Map<ConditionIdentity, Boolean> orResults) {
        List<String> errorGroupsToRemove = new ArrayList<>();
        for (Map.Entry<ConditionIdentity, Boolean> entry : orResults.entrySet()) {
            if (entry.getValue().equals(Boolean.FALSE)) {
                errorGroupsToRemove.add(entry.getKey().getGroup().getName());
            }
        }
        for (String group : errorGroupsToRemove) {
            errorsList.removeIf(error -> error.getGroup().getName().equals(group));
        }
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", operator='" + operator + '\'' +
                ", leftOpId='" + leftOpId + '\'' +
                ", leftOpList=" + leftOpList +
                ", leftOp='" + leftOp + '\'' +
                ", rightOp='" + rightOp + '\'' +
                ", subConditions=" + subConditions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Condition condition = (Condition) o;
        return name.equals(condition.name) &&
                Objects.equals(group, condition.group) &&
                operator.equals(condition.operator) &&
                Objects.equals(leftOpId, condition.leftOpId) &&
                Objects.equals(leftOpList, condition.leftOpList) &&
                Objects.equals(leftOp, condition.leftOp) &&
                Objects.equals(rightOp, condition.rightOp) &&
                Objects.equals(subConditions, condition.subConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operator, leftOpId, leftOpList, leftOp, rightOp, subConditions);
    }
}
