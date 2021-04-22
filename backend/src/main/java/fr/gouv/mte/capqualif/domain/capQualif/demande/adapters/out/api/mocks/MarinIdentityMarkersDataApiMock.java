package fr.gouv.mte.capqualif.domain.capQualif.demande.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.domain.capQualif.demande.domain.marin.MarinIdentityMarkersData;
import org.springframework.stereotype.Component;

@Component
public class MarinIdentityMarkersDataApiMock {
    public MarinIdentityMarkersData findMarinIdentityMarkersByNumeroDeMarin(String numeroDeMarin) {
        MarinIdentityMarkersData marinIdentityMarkersData = new MarinIdentityMarkersData(
                "123",
                "Virginia"
        );
        return marinIdentityMarkersData;
    }
}
