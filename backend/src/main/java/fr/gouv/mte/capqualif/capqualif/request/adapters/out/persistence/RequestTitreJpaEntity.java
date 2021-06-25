package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import javax.persistence.*;

@Entity
@Table(name = "titres")
public class RequestTitreJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;
    private String capacite;
    private Integer validityDurationInYears;
}
