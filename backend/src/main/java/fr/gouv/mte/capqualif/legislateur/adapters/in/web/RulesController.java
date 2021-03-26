package fr.gouv.mte.capqualif.legislateur.adapters.in.web;

import fr.gouv.mte.capqualif.legislateur.domain.Operation;
import fr.gouv.mte.capqualif.legislateur.domain.OperationType;
import fr.gouv.mte.capqualif.legislateur.domain.Operations;
import fr.gouv.mte.capqualif.legislateur.domain.Condition;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/legislateur")
@CrossOrigin(origins = "http://localhost:3000")
public class RulesController {

    @PostMapping("/conditions")
    public void createConditions(@RequestBody Operations operations) {
        List<Operation> sortedOperations = sort(operations);
        List<Operation> intermediateOperations =
                sortedOperations.stream().filter(operation -> operation.getOperationType().equals(OperationType.INTERMEDIATE)).collect(Collectors.toList());
        Operation finalOperation =
                sortedOperations.stream().filter(operation -> operation.getOperationType().equals(OperationType.FINAL)).collect(Collectors.toList()).get(0);
        for (Operation operation : intermediateOperations) {
            operation.setResult(evaluateOperation(operation));
            System.out.println("operation " + operation.getOrder() + " passing: " + operation.getResult());
        }
        System.out.println(evaluateGlobalOperation(finalOperation, intermediateOperations));
    }

    private boolean evaluateGlobalOperation(Operation operation, List<Operation> intermediateOperations) {
        switch (operation.getOperator()) {
            case "AND":
                List<Boolean> resultsAND = new ArrayList<Boolean>();
                for (Operation op : intermediateOperations) {
                    resultsAND.add(op.getResult());
                }
                System.out.println("resultsAND are " + resultsAND);
                if (resultsAND.contains(Boolean.FALSE)) {
                    return false;
                }
                break;
            case "OR":
                List<Boolean> resultsOR = new ArrayList<Boolean>();
                for (Operation op : intermediateOperations) {
                    resultsOR.add(op.getResult());
                }
                System.out.println("resultsOR are " + resultsOR);
                if (resultsOR.contains(Boolean.TRUE)) {
                    return true;
                }
                break;
            default:
                System.out.println("Aouch.");
        }
        return false;
    }

    private List<Operation> sort(Operations operations) {
        return operations.getOperations().stream()
                .sorted(Comparator.comparing(Operation::getOrder))
                .collect(Collectors.toList());
    }

    private boolean evaluateOperation(Operation operation) {
        switch (operation.getOperator()) {
            case "AND":
                for (Condition condition : operation.getRules()) {
                    return rule(operation, condition);
                }
            case "OR":
            // TO DO
        }
        return true;
    }

    private boolean rule(Operation operation, Condition condition) {
        switch (condition.getOperator()) {
            case "==":
                if (condition.getLeftOp().equals(condition.getRightOp())) {
                    System.out.println("subRule " + condition.getRightOp() + " " + condition.getOperator() + " " + condition.getRightOp() + " of operation " + operation.getOrder() + " passes.");
                } else {
                    System.out.println("subRule of operation " + operation.getOrder() + " does not pass because of " + condition.getError());
                    return false;
                }
                break;
            default:
                System.out.println("nothing to show");
        }
        return true;
    }

}