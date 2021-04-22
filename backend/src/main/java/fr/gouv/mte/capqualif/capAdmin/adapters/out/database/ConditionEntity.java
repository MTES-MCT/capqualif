package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conditions")
public class ConditionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operator")
    private String operator;

    @Column(name = "left_operator_id")
    private String leftOpId;

    @Column(name = "left_operator_id")
    private List<String> leftOpList;

    @Column(name = "left_operator")
    private String leftOp;

    @Column(name = "rigth_operator")
    private String rightOp;

    @Column(name = "subconditions")
    private List<fr.gouv.mte.capqualif.capAdmin.domain.Condition> subConditions;

    public ConditionEntity() {
    }

    public ConditionEntity(String operator, String leftOpId, List<String> leftOpList, String leftOp, String rightOp,
                           List<fr.gouv.mte.capqualif.capAdmin.domain.Condition> subConditions) {
        this.operator = operator;
        this.leftOpId = leftOpId;
        this.leftOpList = leftOpList;
        this.leftOp = leftOp;
        this.rightOp = rightOp;
        this.subConditions = subConditions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLeftOpId() {
        return leftOpId;
    }

    public void setLeftOpId(String leftOpId) {
        this.leftOpId = leftOpId;
    }

    public List<String> getLeftOpList() {
        return leftOpList;
    }

    public void setLeftOpList(List<String> leftOpList) {
        this.leftOpList = leftOpList;
    }

    public String getLeftOp() {
        return leftOp;
    }

    public void setLeftOp(String leftOp) {
        this.leftOp = leftOp;
    }

    public String getRightOp() {
        return rightOp;
    }

    public void setRightOp(String rightOp) {
        this.rightOp = rightOp;
    }

    public List<fr.gouv.mte.capqualif.capAdmin.domain.Condition> getSubConditions() {
        return subConditions;
    }

    public void setSubConditions(List<fr.gouv.mte.capqualif.capAdmin.domain.Condition> subConditions) {
        this.subConditions = subConditions;
    }
}