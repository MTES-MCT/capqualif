package fr.gouv.mte.capqualif.legislateur.domain;

public class SubOperation {

    private String operator;
    private String leftOp;
    private String rightOp;
    private boolean result;

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
