package fr.gouv.mte.capqualif.marin.adapters.out.api;

import fr.gouv.mte.capqualif.marin.adapters.out.api.mocks.SailorCivilDataApiMock;
import fr.gouv.mte.capqualif.marin.adapters.out.api.mocks.SailorIdentityMarkersDataApiMock;
import fr.gouv.mte.capqualif.marin.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.marin.domain.Sailor;
import fr.gouv.mte.capqualif.marin.domain.SailorCivilData;
import fr.gouv.mte.capqualif.marin.domain.SailorEducationData;
import fr.gouv.mte.capqualif.marin.domain.SailorIdentityMarkersData;
import fr.gouv.mte.capqualif.sailor.adapters.out.api.mocks.SailorEducationDataApiMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMarinDataAPIAdapter implements GetMarinDataPort {

    @Autowired
    private SailorCivilDataApiMock sailorCivilDataApiMock;

    @Autowired
    private SailorEducationDataApiMock sailorEducationDataApiMock;

    @Autowired
    private SailorIdentityMarkersDataApiMock sailorIdentityMarkersDataApiMock;


    @Override
    public Sailor getMarinData(String sailorNumber) {
        getSailorCivilData(sailorNumber);
        getSailorEducationData(sailorNumber);
        Sailor sailor = new Sailor(
                "123",
                getSailorCivilData(sailorNumber),
                getSailorIdentityMarkersData(sailorNumber),
                getSailorEducationData(sailorNumber)
        );
        return sailor;
    }

    private SailorCivilData getSailorCivilData(String sailorNumber) {
        // TO DO : replace by the actual
        String sailorId = sailorNumber;
        // TO DO : replace by an API call : [URL_BASE_ADM]/api/v1/marins?numIdentification= {numIdentification}
        return sailorCivilDataApiMock.findSailorCivilDataBySailorId(sailorId);
    }

    private SailorEducationData getSailorEducationData(String sailorNumber) {
        String sailorId = sailorNumber;
        // TO DO : replace by an API call : [URL_BASE_ITEM]/api/v1/titres/{idAdmIntervenant}
//        return sailorEducationDataApiMock.findSailorEducationDataBySailorId(sailorId);
        return null;
    }

    private SailorIdentityMarkersData getSailorIdentityMarkersData(String sailorNumber) {
        String sailorId = sailorNumber;
        // TO DO : replace by an API call : [URL_BASE_ITEM]/api/v1/titres/{idAdmIntervenant}
        return sailorIdentityMarkersDataApiMock.findSailorIdentityMarkersBySailorId(sailorNumber);
    }

}
