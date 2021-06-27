package fr.gouv.mte.capqualif.capqualif.request.application.services;

import fr.gouv.mte.capqualif.capqualif.request.application.ports.in.GetMarinBasicDataUseCase;
import fr.gouv.mte.capqualif.capqualif.request.application.ports.out.GetMarinBasicDataPort;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMarinBasicDataService implements GetMarinBasicDataUseCase {

    @Autowired
    private GetMarinBasicDataPort getMarinBasicDataPort;

    @Override
    public Marin getMarinBasicData(String numeroDeMarin) {
        return getMarinBasicDataPort.getMarin(numeroDeMarin);
    }
}
