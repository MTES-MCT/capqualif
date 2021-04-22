package fr.gouv.mte.capqualif.domain.capQualif.demande.application.services;

import fr.gouv.mte.capqualif.domain.capQualif.demande.application.ports.in.GetMarinBasicDataUseCase;
import fr.gouv.mte.capqualif.domain.capQualif.demande.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.domain.capQualif.demande.domain.marin.Marin;
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
