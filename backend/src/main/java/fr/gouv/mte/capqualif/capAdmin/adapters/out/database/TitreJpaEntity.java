package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "titres")
public class TitreJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String conditions;

    //    @ManyToMany
//    @JoinTable(
//            name="titres_conditions",
//            joinColumns = @JoinColumn(name = "titre_id"),
//            inverseJoinColumns = @JoinColumn(name = "condition_id")
//    )
//    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name="condition", referencedColumnName="condition_id")
//    private ConditionJpaEntity conditions;

    public TitreJpaEntity() {
    }

    public TitreJpaEntity(String name, String conditions) {
        this.name = name;
        this.conditions = conditions;
    }

    //    public TitreJpaEntity(String name) {
//        this.name = name;
////        this.conditions = conditions;
//    }


//    public TitreJpaEntity(String name, ConditionJpaEntity conditions) {
//        this.name = name;
//        this.conditions = conditions;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    //    public ConditionJpaEntity getConditions() {
//        return conditions;
//    }
//
//    public void setConditions(ConditionJpaEntity conditions) {
//        this.conditions = conditions;
//    }


//    @Override
//    public String toString() {
//        return "TitreJpaEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", conditions=" + conditions +
//                '}';
//    }
}
