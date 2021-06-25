package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.StatusInstruction;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.StatusResult;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence.RequestJpaEntity;

import javax.persistence.*;

@Entity
@Table(name = "instructions")
public class InstructionJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long marinId;
    private Long titreId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "request_id")
    private RequestJpaEntity request;

    @Enumerated
    private StatusInstruction statusInstruction;

    @Enumerated
    private StatusResult statusResult;

    private String restrictions;
}
