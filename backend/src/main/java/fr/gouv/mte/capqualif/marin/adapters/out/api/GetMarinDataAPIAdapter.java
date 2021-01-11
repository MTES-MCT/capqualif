package fr.gouv.mte.capqualif.marin.adapters.out.api;

import fr.gouv.mte.capqualif.marin.adapters.out.api.mocks.MarinCivilDataApiMock;
import fr.gouv.mte.capqualif.marin.adapters.out.api.mocks.MarinEducationDataApiMock;
import fr.gouv.mte.capqualif.marin.adapters.out.api.mocks.MarinIdentityMarkersDataApiMock;
import fr.gouv.mte.capqualif.marin.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.marin.domain.Marin;
import fr.gouv.mte.capqualif.marin.domain.MarinCivilData;
import fr.gouv.mte.capqualif.marin.domain.MarinEducationData;
import fr.gouv.mte.capqualif.marin.domain.MarinIdentityMarkersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMarinDataAPIAdapter implements GetMarinDataPort {

    @Autowired
    private MarinCivilDataApiMock marinCivilDataApiMock;

    @Autowired
    private MarinEducationDataApiMock marinEducationDataApiMock;

    @Autowired
    private MarinIdentityMarkersDataApiMock marinIdentityMarkersDataApiMock;


    @Override
    public Marin getMarinData(String sailorNumber) {
        getSailorCivilData(sailorNumber);
        getSailorEducationData(sailorNumber);
        Marin marin = new Marin(
                "123",
                getSailorCivilData(sailorNumber),
                getSailorIdentityMarkersData(sailorNumber),
                getSailorEducationData(sailorNumber)
        );
        return marin;
    }

    private MarinCivilData getSailorCivilData(String sailorNumber) {
        // TO DO : replace by the actual
        String sailorId = sailorNumber;
        // TO DO : replace by an API call : [URL_BASE_ADM]/api/v1/marins?numIdentification= {numIdentification}
        return marinCivilDataApiMock.findMarinCivilDataBySailorId(sailorId);
    }

    private MarinEducationData getSailorEducationData(String sailorNumber) {
        String sailorId = sailorNumber;
        // TO DO : replace by an API call : [URL_BASE_ITEM]/api/v1/titres/{idAdmIntervenant}

        return marinEducationDataApiMock.findSailorEducationDataBySailorId(sailorId);
    }

    private MarinIdentityMarkersData getSailorIdentityMarkersData(String sailorNumber) {
        String sailorId = sailorNumber;
        // TO DO : replace by an API call : [URL_BASE_ITEM]/api/v1/titres/{idAdmIntervenant}
        return marinIdentityMarkersDataApiMock.findSailorIdentityMarkersBySailorId(sailorNumber);
    }

}
