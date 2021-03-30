package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.ArrayList;
import java.util.List;

public class Operation {

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

    public boolean validate() {
        switch (operator) {
            case "AND":
                for (Operation op : subOperations) {
                    if (!op.validate()) {
                        errors.add(op.getOperator() + " is errored 1");
                        if (op.getLeftOp() != null) {
                            System.out.println(op.getLeftOp() + " is errored 1");
                        } else {
                            System.out.println(op.getOperator() + " is errored 1");
                        }
                        return false;
                    }
                    ;
                }
                return true;
            case "OR":
                for (Operation op : subOperations) {
                    if (op.validate()) {
                        return true;
                    } else {
                        if (op.getLeftOp() != null) {
                            System.out.println(op.getLeftOp() + " is errored 2");
                        } else {
                            System.out.println(op.getOperator() + " is errored 2");
                        }
                        errors.add(op.getLeftOp() + " is errored 2");
                    }
                }
                return false;
            case "==":
                if (!leftOp.equals(rightOp)) {
                    System.out.println(leftOp + " is errored 3");
                    errors.add(leftOp + " is errored 3");
                    return false;
                } else {
                    return true;
                }
            case ">=":
                if (!(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    System.out.println(leftOp + " is errored 4");
                    errors.add(leftOp + " is errored 4");
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
