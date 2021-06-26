package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import javax.persistence.*;

@Entity
@Table(name = "request_titre")
public class RequestTitreJpaEntity {

    public RequestTitreJpaEntity() {};

    public RequestTitreJpaEntity(String name, String slug, String capacite, Integer validityDurationInYears) {
        this.name = name;
        this.slug = slug;
        this.capacite = capacite;
        this.validityDurationInYears = validityDurationInYears;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;
    private String capacite;
    private Integer validityDurationInYears;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getCapacite() {
        return capacite;
    }

    public Integer getValidityDurationInYears() {
        return validityDurationInYears;
    }

    @Override
    public String toString() {
        return "RequestTitreJpaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", capacite='" + capacite + '\'' +
                ", validityDurationInYears=" + validityDurationInYears +
                '}';
    }
}
