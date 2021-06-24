package fr.gouv.mte.capqualif.capqualif.request.application.services;

import fr.gouv.mte.capqualif.capqualif.request.application.ports.in.CreateRequestUseCase;
import fr.gouv.mte.capqualif.capqualif.request.application.ports.out.CreateRequestPort;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRequestService implements CreateRequestUseCase {

    @Autowired
    CreateRequestPort createRequestPort;

    public CreateRequestService(CreateRequestPort createRequestPort) {
        this.createRequestPort = createRequestPort;
    }

    public Request createRequest(Request request) {
        return createRequestPort.createRequest((request));
    }

}
