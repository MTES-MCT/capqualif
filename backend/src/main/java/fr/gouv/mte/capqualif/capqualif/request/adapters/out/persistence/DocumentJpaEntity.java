package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class DocumentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ManyToOne
    @JoinColumn(name = "request_id")
    private RequestJpaEntity request;

    @Column
    private String value;
}
