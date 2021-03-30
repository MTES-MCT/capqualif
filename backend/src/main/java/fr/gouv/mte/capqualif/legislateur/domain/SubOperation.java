package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.List;

public class SubOperation {

    private String operator;
    private String leftOp;
    private String rightOp;
    private boolean result;
    private List<String> errors;

    public String getError() {
        return leftOp;
    }

    public String getOperator() {
        return operator;
    }

    public String getLeftOp() {
        return leftOp;
    }

    public String getRightOp() {
        return rightOp;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }


    public boolean validate() {
        switch (operator) {
            case "==":
                if (!leftOp.equals(rightOp)) {
                    this.errors.add(leftOp + " is errored");
                    return false;
                } else {
                    return true;
                }
            case ">=":
                if (!(Integer.parseInt(leftOp) >= Integer.parseInt(rightOp))) {
                    this.errors.add(leftOp + " is errored");
                    return false;
                } else {
                    return true;
                }
            default:
                System.out.println("evaluateSubOperation aouch");
                break;
        }
        return false;
    }

    @Override
    public String toString() {
        return "SubOperation{" +
                "operator='" + operator + '\'' +
                ", leftOp='" + leftOp + '\'' +
                ", rightOp='" + rightOp + '\'' +
                ", result=" + result +
                '}';
    }
}
