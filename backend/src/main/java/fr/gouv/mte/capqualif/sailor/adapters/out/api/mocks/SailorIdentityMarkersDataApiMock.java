package fr.gouv.mte.capqualif.sailor.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.sailor.domain.SailorIdentityMarkersData;
import org.springframework.stereotype.Component;

@Component
public class SailorIdentityMarkersDataApiMock {
    public SailorIdentityMarkersData findSailorIdentityMarkersBySailorId(String sailorId) {
        SailorIdentityMarkersData sailorIdentityMarkersData = new SailorIdentityMarkersData(
                "123",
                "Virginia"
        );
        return sailorIdentityMarkersData;
    }
}
