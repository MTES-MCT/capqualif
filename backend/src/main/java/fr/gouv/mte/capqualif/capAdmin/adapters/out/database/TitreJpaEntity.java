//package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "titres")
//public class TitreJpaEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
////    @ManyToMany
////    @JoinTable(
////            name="titres_conditions",
////            joinColumns = @JoinColumn(name = "titre_id"),
////            inverseJoinColumns = @JoinColumn(name = "condition_id")
////    )
//    private Set<ConditionJpaEntity> conditions;
//
//    public TitreJpaEntity() {
//    }
//
////    public TitreJpaEntity(String name) {
////        this.name = name;
//////        this.conditions = conditions;
////    }
//
//    public TitreJpaEntity(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<ConditionJpaEntity> getConditions() {
//        return conditions;
//    }
//
//    public void setConditions(Set<ConditionJpaEntity> conditions) {
//        this.conditions = conditions;
//    }
//}
