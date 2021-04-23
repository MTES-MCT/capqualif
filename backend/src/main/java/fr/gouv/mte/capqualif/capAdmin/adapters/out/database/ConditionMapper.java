package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConditionMapper {

    public ConditionJpaEntity mapToJpaEntity(Condition condition) {

        ConditionJpaEntity conditionJpaEntity = new ConditionJpaEntity(
                condition.getName(),
                condition.getOperator(),
                condition.getLeftOpId(),
                condition.getLeftOpList(),
                condition.getLeftOp(),
                condition.getRightOp()
        );

        if (condition.getSubConditions() != null) {
            List<ConditionJpaEntity> subConditions = new ArrayList<>();
            for (Condition subCondition : condition.getSubConditions()) {
                subConditions.add(mapToJpaEntity(subCondition));
                conditionJpaEntity.setSubConditions(subConditions);
            }
        }
//        System.out.println("\n" + conditionJpaEntity);
        return conditionJpaEntity;
    }

}
