package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.*;

public class Condition {

    private String id;
    private String operator;
    private String leftOp;
    private String rightOp;
    private List<Condition> subConditions;
    private boolean result;

    public String getOperator() {
        return operator;
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

    public boolean isResult() {
        return result;
    }

    public String getId() {
        return id;
    }

    public void populateWithData(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            boolean isValueReplaced = false;
            replaceWithValue(entry.getKey(), entry.getValue(), isValueReplaced);
        }
    }

    public boolean replaceWithValue(String key, String value, boolean isValueReplaced) {
        if (key.equals(id)) {
            System.out.println(id);
            System.out.println(leftOp);
            setLeftOp(value);
            System.out.println(leftOp);
            return true;
        } else {
            if (subConditions != null) {
                for (Condition subCondition : subConditions) {
                    isValueReplaced = subCondition.replaceWithValue(key, value, isValueReplaced);
                    System.out.println(isValueReplaced);
                    if(isValueReplaced) break;
                }
            }
        }
        return false;
    }

    public boolean validate(List<String> errorsList) {
        switch (operator) {
            case "AND":
                Map<String, Boolean> andResults = new HashMap<>();
                if (subConditions != null) {
                    for (Condition subCondition : subConditions) {
                        boolean validationResult = subCondition.validate(errorsList);
                        andResults.put(subCondition.getId(), validationResult);
                    }
                }
                System.out.println("andResults : " + andResults);
                if (andResults.containsValue(Boolean.FALSE)) {
                    return false;
                }
                return true;
            case "OR":
                Map<String, Boolean> orResults = new HashMap<>();
                if (subConditions != null) {
                    for (Condition subCondition : subConditions) {
                        boolean validationResult = subCondition.validate(errorsList);
                        orResults.put(subCondition.getId(), validationResult);
                    }
                }
                System.out.println("orResults : " + orResults);
                if (orResults.containsValue(Boolean.TRUE)) {
                    removeOtherFalseErrors(errorsList, orResults);
                    return true;
                }
                return false;
            case "==":
                if (!leftOp.equals(rightOp)) {
                    errorsList.add(id);
                    return false;
                } else {
                    return true;
                }
            case ">=":
                if (!(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    errorsList.add(id);
                    return false;
                } else {
                    return true;
                }
            default:
                System.out.println("validate aouch.");
                break;
        }
        System.out.println("Falling out of switch !");
        return false;
    }

    private void removeOtherFalseErrors(List<String> errorsList, Map<String, Boolean> orResults) {
        List<String> ids = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : orResults.entrySet()) {
            if (entry.getValue().equals(Boolean.FALSE)) {
                ids.add(entry.getKey());
            }
        }
        errorsList.removeAll(ids);
    }


    @Override
    public String toString() {
        return "Condition{" +
                "id='" + id + '\'' +
                ", operator='" + operator + '\'' +
                ", leftOp='" + leftOp + '\'' +
                ", rightOp='" + rightOp + '\'' +
                ", subConditions=" + subConditions +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Condition condition = (Condition) o;
        return result == condition.result &&
                id.equals(condition.id) &&
                operator.equals(condition.operator) &&
                Objects.equals(leftOp, condition.leftOp) &&
                Objects.equals(rightOp, condition.rightOp) &&
                Objects.equals(subConditions, condition.subConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operator, leftOp, rightOp, subConditions, result);
    }
}
