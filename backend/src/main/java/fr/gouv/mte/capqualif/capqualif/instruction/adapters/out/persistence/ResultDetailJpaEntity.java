package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.statuses.StatusResultDetails;

import javax.persistence.*;

@Entity
@Table(name = "result_detail")
public class ResultDetailJpaEntity {

    public ResultDetailJpaEntity() {};

    public ResultDetailJpaEntity(Long requestId, String groupName, String name, String marinData,
                                 StatusResultDetails statusResultDetailsId) {
        this.requestId = requestId;
        this.groupName = groupName;
        this.name = name;
        this.marinData = marinData;
        this.statusResultDetailsId = statusResultDetailsId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;

    private String groupName;

    private String name;

    private String marinData;

    @Enumerated
    private StatusResultDetails statusResultDetailsId;

    public Long getId() {
        return id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getName() {
        return name;
    }

    public String getMarinData() {
        return marinData;
    }

    public StatusResultDetails getStatusResultDetailsId() {
        return statusResultDetailsId;
    }
}
