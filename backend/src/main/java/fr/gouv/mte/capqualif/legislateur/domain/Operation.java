package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.ArrayList;
import java.util.List;

public class Operation {

    private String id;
    private String operator;
    private String leftOp;
    private String rightOp;
    private List<Operation> subOperations;
    private boolean result;
    private List<String> errors = new ArrayList<>();

    public String getOperator() {
        return operator;
    }

    public String getLeftOp() {
        return leftOp;
    }

    public String getRightOp() {
        return rightOp;
    }

    public List<Operation> getSubOperations() {
        return subOperations;
    }

    public boolean isResult() {
        return result;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getId() {
        return id;
    }

    public boolean validate() {
        switch (operator) {
            case "AND":
                for (Operation subOp : subOperations) {
                    if (!subOp.validate()) {
//                        errors.add(subOp.getOperator() + " is errored 1");
//                        System.out.println(subOp.getId() + " is errored 1");
                        System.out.println(getId() + " " + getOperator() + " is errored 1");
                        return false;
                    }
                    ;
                }
                System.out.println(getId() + " " + getOperator() + " is OK 2");
                return true;
            case "OR":
                for (Operation op : subOperations) {
                    if (op.validate()) {
                        System.out.println(getId() + " " + getOperator() + " is OK 2");
                        return true;
                    }
                }
                System.out.println(getId() + " " + getOperator() + " is errored 2");
                return false;
            case "==":
                if (!leftOp.equals(rightOp)) {
                    System.out.println(getId() + " is errored 3");
                    errors.add(getId() + " is errored 3");
                    return false;
                } else {
                    return true;
                }
            case ">=":
                if (!(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    System.out.println(getId() + " is errored 4");
                    errors.add(getId() + " is errored 4");
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

    @Override
    public String toString() {
        return "Operation{" +
                "operator='" + operator + '\'' +
                ", leftOp='" + leftOp + '\'' +
                ", rightOp='" + rightOp + '\'' +
                ", subOperations=" + subOperations +
                ", result=" + result +
                ", errors=" + errors +
                '}';
    }
}
