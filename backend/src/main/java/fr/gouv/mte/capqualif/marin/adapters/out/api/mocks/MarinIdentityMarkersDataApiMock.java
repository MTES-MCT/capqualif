package fr.gouv.mte.capqualif.marin.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.marin.domain.MarinIdentityMarkersData;
import org.springframework.stereotype.Component;

@Component
public class MarinIdentityMarkersDataApiMock {
    public MarinIdentityMarkersData findSailorIdentityMarkersBySailorId(String sailorId) {
        MarinIdentityMarkersData marinIdentityMarkersData = new MarinIdentityMarkersData(
                "123",
                "Virginia"
        );
        return marinIdentityMarkersData;
    }
}
