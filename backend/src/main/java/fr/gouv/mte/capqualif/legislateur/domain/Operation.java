package fr.gouv.mte.capqualif.legislateur.domain;

import java.util.List;

public class Operation {
    private int order;
    private OperationType operationType;
    private String operator;
    private List<Condition> conditions;
    private boolean result;

    public String getOperator() {
        return operator;
    }

    public List<Condition> getRules() {
        return conditions;
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

    @Override
    public String toString() {
        return "Operation{" +
                "operationOrder=" + order +
                ", operator='" + operator + '\'' +
                ", subRules=" + conditions +
                '}';
    }
}
