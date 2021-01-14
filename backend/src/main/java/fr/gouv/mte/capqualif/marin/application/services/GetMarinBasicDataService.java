package fr.gouv.mte.capqualif.marin.application.services;

import fr.gouv.mte.capqualif.marin.application.ports.in.GetMarinBasicDataUseCase;
import fr.gouv.mte.capqualif.marin.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.MarinDto;
import fr.gouv.mte.capqualif.marin.domain.marin.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMarinBasicDataService implements GetMarinBasicDataUseCase {

    @Autowired
    private GetMarinDataPort getMarinDataPort;

    @Override
    public Marin getMarinBasicData(String numeroDeMarin) {
        return getMarinDataPort.getMarin(numeroDeMarin);
    }
}
