package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conditions")
public class ConditionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //    @ManyToMany(mappedBy = "conditions")
//    private Set<TitreJpaEntity> titreJpaEntity;

    @Column(name = "operator")
    private String operator;

    @Column(name = "left_operator_id")
    private String leftOpId;

    @ElementCollection
    @Column(name = "left_operator_list")
    private List<String> leftOpList;

    @Column(name = "left_operator")
    private String leftOp;

    @Column(name = "right_operator")
    private String rightOp;

    //    @OneToMany(mappedBy = "parentCondition")
//    @Column(name = "subconditions")
    @ElementCollection
    private List<ConditionJpaEntity> subConditions;
//
//    @ManyToOne
//    private Condition parentCondition;

    public ConditionJpaEntity() {
    }

    public ConditionJpaEntity(String name, String operator, String leftOpId,
                              List<String> leftOpList, String leftOp, String rightOp) {
        this.name = name;
        this.operator = operator;
        this.leftOpId = leftOpId;
        this.leftOpList = leftOpList;
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<TitreJpaEntity> getTitreEntity() {
//        return titreJpaEntity;
//    }
//
//    public void setTitreEntity(Set<TitreJpaEntity> titreJpaEntity) {
//        this.titreJpaEntity = titreJpaEntity;
//    }

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

    public List<ConditionJpaEntity> getSubConditions() {
        return subConditions;
    }

    public void setSubConditions(List<ConditionJpaEntity> subConditions) {
        this.subConditions = subConditions;
    }

    @Override
    public String toString() {
        return "ConditionJpaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", operator='" + operator + '\'' +
                ", leftOpId='" + leftOpId + '\'' +
                ", leftOpList=" + leftOpList +
                ", leftOp='" + leftOp + '\'' +
                ", rightOp='" + rightOp + '\'' +
                ", subConditions=" + subConditions +
                '}';
    }
}