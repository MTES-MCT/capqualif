package fr.gouv.mte.capqualif.marin.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.marin.domain.MarinCivilData;
import org.springframework.stereotype.Component;

@Component
public class MarinCivilDataApiMock {

    public MarinCivilData findMarinCivilDataBySailorId(String sailorId) {
        MarinCivilData marinCivilData = new MarinCivilData(
                "123",
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