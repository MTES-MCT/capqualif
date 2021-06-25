package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.persistence.InstructionJpaEntity;
import fr.gouv.mte.capqualif.capqualif.request.domain.request.StatusRequest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "requests")
public class RequestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestorId;

    public Long requestedTitreId;

    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public InstructionJpaEntity instruction;

    @Enumerated
    private StatusRequest statusRequest;

    private LocalDateTime startDate;

    private LocalDateTime updateDate;

    private Long agentId;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<DocumentJpaEntity> documents;
}
