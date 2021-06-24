package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.request.application.ports.out.CreateRequestPort;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Request;
import org.springframework.stereotype.Component;

@Component
public class CreateRequestAdapter implements CreateRequestPort {
    @Override
    public Request createRequest(Request request) {
        return null;
    }
}
