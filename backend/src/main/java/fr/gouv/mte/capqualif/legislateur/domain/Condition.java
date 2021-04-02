package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Condition {

    private String id;
    private String operator;
    private String leftOp;
    private String rightOp;
    private List<Condition> subConditions;
    private boolean result;
    private List<String> errors;

    public String getOperator() {
        return operator;
    }

    public String getLeftOp() {
        return leftOp;
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

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getId() {
        return id;
    }

    public boolean validate() {
        switch (operator) {
            case "AND":
                Map<String, Boolean> andResults = new HashMap<>();
                for (Condition subCondition : subConditions) {
                    andResults.put(subCondition.getId(), subCondition.validate());
                }
                System.out.println("andResults : " + andResults);
                if (andResults.containsValue(Boolean.FALSE)) return false;
                return true;
            case "OR":
                Map<String, Boolean> orResults = new HashMap<>();
                for (Condition subCondition : subConditions) {
                    orResults.put(subCondition.getId(), subCondition.validate());
                }
                System.out.println("orResults : " + orResults);
                if (orResults.containsValue(Boolean.TRUE)) return true;
                return false;
            case "==":
                if (!leftOp.equals(rightOp)) {
//                    System.out.println(getId() + " is errored 3");
                    return false;
                } else {
                    return true;
                }
            case ">=":
                if (!(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
//                    System.out.println(getId() + " is errored 4");
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
}
