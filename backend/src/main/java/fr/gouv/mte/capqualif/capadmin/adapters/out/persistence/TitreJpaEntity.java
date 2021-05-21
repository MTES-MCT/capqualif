package fr.gouv.mte.capqualif.capadmin.adapters.out.persistence;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "titre")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class TitreJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String conditions;


    public TitreJpaEntity() {
    }

    public TitreJpaEntity(String titre, String conditions) {
        this.titre = titre;
        this.conditions = conditions;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "TitreJpaEntity{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}