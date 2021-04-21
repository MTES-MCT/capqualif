package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.*;

public class Condition {

    private String id;
    private String operator;
    private String leftOpId;
    private List<String> leftOpList;
    private String leftOp;
    private String rightOp;
    private List<Condition> subConditions;
    private boolean result;

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

    public boolean isResult() {
        return result;
    }

    public String getId() {
        return id;
    }

    public String getLeftOpId() {
        return leftOpId;
    }

    public void populateWithData(Marin marin) {
        for (Data data : marin.getData()) {
            boolean done = false;
            System.out.println("\n ok, let'ds go for " + data.getJuridicalDesignation());
            replaceWithValue(data);
        }
    }

    public boolean replaceWithValue(Data data) {
        if (data.getJuridicalDesignation().equals(leftOpId)) {
            replace(data);
            return true;
        } else {
            if (subConditions != null) {
                for (Condition subcondition : subConditions) {
                    boolean done = subcondition.replaceWithValue(data);
                    System.out.println("\n" + subcondition.getId() + "\n is " + done + "\n for " + data.getJuridicalDesignation());
                    if (done) {
                        System.out.println("just before the true return");
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private void replace(Data data) {
        if (data.getValue() instanceof String) {
            setLeftOp((String) data.getValue());
            System.out.println(leftOp);
        }
        if (data.getValue() instanceof List) {
            setLeftOpList((List<String>) data.getValue());
            System.out.println(leftOpList);
        }
    }

    private void replace(Condition condition, Data data) {
        if (data.getValue() instanceof String) {
            condition.setLeftOp((String) data.getValue());
            System.out.println(condition.leftOp);
        }
        if (data.getValue() instanceof List) {
            condition.setLeftOpList((List<String>) data.getValue());
            System.out.println(condition.leftOpList);
        }
    }

//        if (data.getJuridicalDesignation().equals(id)) {
//            System.out.println(id);
//            System.out.println("leftOp is " + leftOp);
//            System.out.println("leftOpList is " + leftOpList);
//            if (data.getValue() instanceof String) {
//                setLeftOp((String) data.getValue());
//                System.out.println(leftOp);
//                done = true;
//            }
//            if (data.getValue() instanceof List) {
//                setLeftOpList((List<String>) data.getValue());
//                System.out.println(leftOpList);
//                done = true;
//            }
//        } else {
//            if (subConditions != null) {

//                for (Condition subcondition : subConditions) {
//                    System.out.println("before done is " + done);
//                    subcondition.replaceWithValue(data, done);
//                    System.out.println("after done is " + done);
//                }


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
                    removeErrorsFromOtherFalseSubconditions(errorsList, orResults);
                    return true;
                }
                return false;
            case "==":
                if (!leftOp.equals(rightOp)) {
                    addToErrors(errorsList, id);
                    return false;
                } else {
                    return true;
                }
            case ">=":
                if (!(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    addToErrors(errorsList, id);
                    return false;
                } else {
                    return true;
                }
            case "contains":
                if (leftOpList.contains(rightOp)) {
                    return true;
                } else {
                    addToErrors(errorsList, id);
                    return false;
                }
            default:
                System.out.println("validate aouch.");
                break;
        }
        System.out.println("Falling out of switch !");
        return false;
    }

    private void addToErrors(List<String> errorsList, String id) {
        errorsList.add(id);
    }

    private void removeErrorsFromOtherFalseSubconditions(List<String> errorsList, Map<String, Boolean> orResults) {
        List<String> ids = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : orResults.entrySet()) {
            if (entry.getValue().equals(Boolean.FALSE)) {
                addToErrors(ids, entry.getKey());
            }
        }
        errorsList.removeAll(ids);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id='" + id + '\'' +
                ", operator='" + operator + '\'' +
                ", leftOpId='" + leftOpId + '\'' +
                ", leftOpList=" + leftOpList +
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
                Objects.equals(id, condition.id) &&
                Objects.equals(operator, condition.operator) &&
                Objects.equals(leftOpId, condition.leftOpId) &&
                Objects.equals(leftOpList, condition.leftOpList) &&
                Objects.equals(leftOp, condition.leftOp) &&
                Objects.equals(rightOp, condition.rightOp) &&
                Objects.equals(subConditions, condition.subConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operator, leftOpId, leftOpList, leftOp, rightOp, subConditions, result);
    }
}
