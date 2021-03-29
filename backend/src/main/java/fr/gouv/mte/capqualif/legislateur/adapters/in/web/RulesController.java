package fr.gouv.mte.capqualif.legislateur.adapters.in.web;

import fr.gouv.mte.capqualif.legislateur.domain.Operation;
import fr.gouv.mte.capqualif.legislateur.domain.OperationType;
import fr.gouv.mte.capqualif.legislateur.domain.Operations;
import fr.gouv.mte.capqualif.legislateur.domain.SubOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/legislateur")
@CrossOrigin(origins = "http://localhost:3000")
public class RulesController {

    // blablabla

    @PostMapping("/conditions")
    public void createConditions(@RequestBody Operations operations) {
        List<Operation> sortedOperations = sort(operations);
        List<Operation> atomicOperations =
                sortedOperations.stream().filter(operation -> operation.getOperationType().equals(OperationType.ATOMIC)).collect(Collectors.toList());
        List<Operation> intermediateOperations =
                sortedOperations.stream().filter(operation -> operation.getOperationType().equals(OperationType.INTERMEDIATE)).collect(Collectors.toList());
        Operation finalOperation =
                sortedOperations.stream().filter(operation -> operation.getOperationType().equals(OperationType.FINAL)).collect(Collectors.toList()).get(0);
        // Process atomic operations
        for (Operation atomicOperation : atomicOperations) {
            atomicOperation.setResult(evaluateAtomicOperation(atomicOperation));
        }
        // Process intermediate operations
        for (Operation intermediateOperation : intermediateOperations) {
            intermediateOperation.setResult(evaluateIntermediateOrFinalOperation(intermediateOperation, sortedOperations));
        }
        finalOperation.setResult(evaluateIntermediateOrFinalOperation(finalOperation, sortedOperations));
        System.out.println(finalOperation);
    }

    private boolean evaluateAtomicOperation(Operation operation) {
        List<Boolean> subOperationsResults = new ArrayList<Boolean>();
        for (SubOperation subOperation : operation.getSubOperations()) {
            subOperation.setResult(evaluateSubOperation(subOperation));
            subOperationsResults.add(subOperation.getResult());
        }
        switch (operation.getOperator()) {
            case "AND":
                return andChecker(subOperationsResults);
            case "OR":
                return orChecker(subOperationsResults);
            default:
                System.out.println("evaluateAtomicOperation aouch.");
                break;
        }
        return true;
    }

    private boolean evaluateIntermediateOrFinalOperation(Operation operation, List<Operation> operations) {
        List<Operation> wantdOperations = findOperationsById(operation.getComparedIntermediateResultsOfOperations(), operations);
        List<Boolean> operationsResults = new ArrayList<Boolean>();
        for (Operation op : wantdOperations) {
            operationsResults.add(op.getResult());
        }
        switch (operation.getOperator()) {
            case "AND":
                return andChecker(operationsResults);
            case "OR":
                return orChecker(operationsResults);
            default:
                System.out.println("evaluateIntermediateOperation aouch.");
                break;
        }
        return false;
    }

    private boolean evaluateSubOperation(SubOperation subOperation) {
        switch (subOperation.getOperator()) {
            case "==":
                return subOperation.getLeftOp().equals(subOperation.getRightOp());
            default:
                System.out.println("evaluateSubOperation aouch");
                break;
        }
        return true;
    }

    private List<Operation> findOperationsById(List<String> ids, List<Operation> operations) {
        List<Operation> results = new ArrayList<>();
        for (String id : ids) {
            results.add((Operation) operations.stream().filter(operation -> operation.getId().equals(id)));
        }
        return results;
    }

    private boolean orChecker(List<Boolean> results) {
        return results.contains(Boolean.TRUE);
    }

    private Boolean andChecker(List<Boolean> results) {
        return !results.contains(Boolean.FALSE);
    }

    private List<Operation> sort(Operations operations) {
        return operations.getOperations().stream()
                .sorted(Comparator.comparing(Operation::getOrder))
                .collect(Collectors.toList());
    }
}