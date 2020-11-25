package fr.gouv.mte.capqualif.sailor.application.services;

import fr.gouv.mte.capqualif.sailor.application.ports.in.GetSailorBasicDataUseCase;
import fr.gouv.mte.capqualif.sailor.application.ports.out.GetSailorDataPort;
import fr.gouv.mte.capqualif.sailor.domain.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSailorBasicDataService implements GetSailorBasicDataUseCase {

    @Autowired
    private GetSailorDataPort getSailorDataPort;

    @Override
    public Sailor getSailorBasicData(String id) {
        return getSailorDataPort.getSailorData(id);
    }
}
