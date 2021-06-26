package fr.gouv.mte.capqualif.capadmin.domain;

import fr.gouv.mte.capqualif.capadmin.domain.temp.Marin;

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

    private boolean containsResult(List<ConditionResult> list, boolean result){
        return list.stream().filter(o -> o.getResult().equals(result)).findFirst().isPresent();
    }

    public boolean validate(List<ConditionResult> logs) {
        switch (operator) {
            case "AND":
                List<ConditionResult> andResults = new ArrayList<>();
                if (subConditions != null) {
                    for (Condition subCondition : subConditions) {
                        boolean validationResult = subCondition.validate(logs);
                        andResults.add(new ConditionResult(subCondition.getGroup().getName(), subCondition.getName(), validationResult));
                    }
                }
                System.out.println("andResults : " + andResults);
                if (containsResult(andResults, Boolean.FALSE)) {
                    return false;
                }
                return true;
            case "OR":
                List<ConditionResult> orResults = new ArrayList<>();
                if (subConditions != null) {
                    for (Condition subCondition : subConditions) {
                        boolean validationResult = subCondition.validate(logs);
                        orResults.add(new ConditionResult(subCondition.getGroup().getName(), subCondition.getName(), validationResult));
                    }
                }
                System.out.println("orResults : " + orResults);
                if (containsResult(orResults, Boolean.TRUE)) {
                    removeErrorsFromOtherFalseSubconditions(logs, orResults);
                    return true;
                }
                return false;
            case "==":
                if (leftOp.isEmpty() || !leftOp.equals(rightOp)) {
                    addToLogs(logs, name, group, false);
                    return false;
                }
                addToLogs(logs, name, group, true);
                return true;
            case ">=":
                if (leftOp.isEmpty() || !(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    addToLogs(logs, name, group, false);
                    return false;
                }
                addToLogs(logs, name, group, true);
                return true;
            case "contains":
                if (!leftOpList.contains(rightOp)) {
                    addToLogs(logs, name, group, false);
                    return false;
                }
                addToLogs(logs, name, group, true);
                return true;
            default:
                System.out.println("validate aouch.");
                break;
        }
        System.out.println("Falling out of switch !");
        return false;
    }

    private void addToLogs(List<ConditionResult> logs, String name, Group group, boolean isValid) {
        logs.add(new ConditionResult(name, group.getName(), isValid));
    }

    /*
    * For an OR condition, if one of the subconditions is satisfied, we remove other not satisfied conditions so it does not pollute or results
    */
    private void removeErrorsFromOtherFalseSubconditions(List<ConditionResult> errorsList, List<ConditionResult> orResults) {
        List<String> errorGroupsToRemove = new ArrayList<>();
        for(ConditionResult orResult : orResults) {
            if (orResult.getResult().equals(Boolean.FALSE)) {
                errorGroupsToRemove.add(orResult.getName());
            }
        }

//        for (Map.Entry<ConditionIdentity, Boolean> entry : orResults.entrySet()) {
//            if (entry.getValue().equals(Boolean.FALSE)) {
//                errorGroupsToRemove.add(entry.getKey().getGroup().getName());
//            }
//        }
        for (String group : errorGroupsToRemove) {
            errorsList.removeIf(error -> error.getGroup().equals(group));
//            errorsList.removeIf(error -> error.getGroup().getName().equals(group));
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
