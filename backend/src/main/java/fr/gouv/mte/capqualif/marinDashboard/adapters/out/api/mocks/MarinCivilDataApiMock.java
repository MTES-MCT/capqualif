package fr.gouv.mte.capqualif.marinDashboard.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.marinDashboard.domain.MarinCivilData;
import org.springframework.stereotype.Component;

@Component
public class MarinCivilDataApiMock {

    public MarinCivilData findMarinCivilDataByNumeroDeMarin(String numeroDeMarin) {
        MarinCivilData marinCivilData = new MarinCivilData(
                numeroDeMarin,
                "Virginia",
                "Wolf",
                "25/05/1985",
                "London",
                "5, Baker Street",
                "virginia@gmail.fr"
        );
        return marinCivilData;
    }
}