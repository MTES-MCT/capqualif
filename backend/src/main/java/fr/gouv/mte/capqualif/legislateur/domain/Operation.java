package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.List;

public class Operation {
    private String id;
    private int order;
    private OperationType operationType;
    private String operator;
    private List<SubOperation> subOperations;
    private List<String> comparedIntermediateResultsOfOperations;
    private boolean result;

    public String getId() {
        return id;
    }

    public String getOperator() {
        return operator;
    }

    public List<SubOperation> getComparedConditions() {
        return subOperations;
    }

    public List<String> getComparedIntermediateResultsOfOperations() {
        return comparedIntermediateResultsOfOperations;
    }

    public int getOrder() {
        return order;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public List<SubOperation> getSubOperations() {
        return subOperations;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id='" + id + '\'' +
                ", order=" + order +
                ", operationType=" + operationType +
                ", operator='" + operator + '\'' +
                ", comparedConditions=" + subOperations +
                ", comparedOperations=" + comparedIntermediateResultsOfOperations +
                ", result=" + result +
                '}';
    }
}
