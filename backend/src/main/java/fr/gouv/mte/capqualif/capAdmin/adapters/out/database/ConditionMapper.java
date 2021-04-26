package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConditionMapper {

    @Autowired
    private ConditionRepository conditionRepository;

    public ConditionJpaEntity mapToJpaEntity(Condition condition) {

        System.out.println(condition);

        ConditionJpaEntity conditionJpaEntityToSave = new ConditionJpaEntity(
                condition.getName(),
                condition.getOperator(),
                condition.getLeftOpId(),
                condition.getLeftOpList(),
                condition.getLeftOp(),
                condition.getRightOp()
        );

        System.out.println("conditionJpaEntityToSave is" + conditionJpaEntityToSave);

        ConditionJpaEntity savedConditionJpaEntity = this.conditionRepository.save(conditionJpaEntityToSave);
        System.out.println("saved is " + savedConditionJpaEntity);

        if (condition.getSubConditions() != null) {
            List<ConditionJpaEntity> subConditions = new ArrayList<>();
            for (Condition subCondition : condition.getSubConditions()) {
                subConditions.add(mapToJpaEntity(subCondition));
                savedConditionJpaEntity.setSubConditions(subConditions);;
                this.conditionRepository.save(savedConditionJpaEntity);
            }
        }
        System.out.println("and now " + savedConditionJpaEntity);
        return savedConditionJpaEntity;
    }

}
