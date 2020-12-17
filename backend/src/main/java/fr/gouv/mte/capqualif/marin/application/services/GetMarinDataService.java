package fr.gouv.mte.capqualif.marin.application.services;

import fr.gouv.mte.capqualif.marin.application.ports.in.GetMarinDataUseCase;
import fr.gouv.mte.capqualif.marin.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.marin.domain.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMarinDataService implements GetMarinDataUseCase {

    @Autowired
    private GetMarinDataPort getMarinDataPort;

    @Override
    public Sailor getMarinData(String id) {
        return getMarinDataPort.getMarinData(id);
    }
}
