package fr.gouv.mte.capqualif.capqualif.request.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.request.domain.request.Request;

public interface CreateRequestPort {
    Request createRequest(Request request);
}
