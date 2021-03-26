package fr.gouv.mte.capqualif.legislateur.domain;

public class Condition {

    private String operator;
    private String leftOp;
    private String rightOp;

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

    @Override
    public String toString() {
        return "Condition{" +
                "operator='" + operator + '\'' +
                ", leftOp='" + leftOp + '\'' +
                ", rightOp='" + rightOp + '\'' +
                '}';
    }
}
