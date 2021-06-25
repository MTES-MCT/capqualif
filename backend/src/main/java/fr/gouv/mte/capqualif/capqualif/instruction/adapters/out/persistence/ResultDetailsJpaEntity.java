package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.StatusResultDetails;

import javax.persistence.*;

@Entity
@Table(name = "result_details")
public class ResultDetailsJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;

    private String group;

    private String name;

    private String marinData;

    @Enumerated
    private StatusResultDetails statusResultDetailsId;
}
