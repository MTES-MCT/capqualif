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

    public String getId() {
        return id;
    }

    public boolean validate(List<String> errorsList) {
        switch (operator) {
            case "AND":
                Map<String, Boolean> andResults = new HashMap<>();
                for (Condition subCondition : subConditions) {
                    boolean validationResult = subCondition.validate(errorsList);
                    andResults.put(subCondition.getId(), validationResult);
                }
                System.out.println("andResults : " + andResults);
                if (andResults.containsValue(Boolean.FALSE)) {
                    return false;
                }
                return true;
            case "OR":
                Map<String, Boolean> orResults = new HashMap<>();
                for (Condition subCondition : subConditions) {
                    boolean validationResult = subCondition.validate(errorsList);
                    orResults.put(subCondition.getId(), validationResult);
                }
                System.out.println("orResults : " + orResults);
                if (orResults.containsValue(Boolean.TRUE)) return true;
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
}
