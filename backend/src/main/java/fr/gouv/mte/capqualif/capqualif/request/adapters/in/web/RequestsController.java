package fr.gouv.mte.capqualif.capqualif.request.adapters.in.web;

import fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence.RequestTitreJpaEntity;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence.RequestTitreRepository;
import fr.gouv.mte.capqualif.capqualif.request.application.ports.in.CreateRequestUseCase;
import fr.gouv.mte.capqualif.capqualif.request.domain.request.Request;
import fr.gouv.mte.capqualif.capqualif.request.domain.request.RequestTitre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@CrossOrigin(origins = "http://localhost:3000")
public class RequestsController {

    @Autowired
    private CreateRequestUseCase createRequestUseCase;

    @Autowired
    private RequestTitreRepository requestTitreRepository;

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        System.out.println(request);
        return createRequestUseCase.createRequest(request);
    }

    @GetMapping("/test")
    public RequestTitre getAllTitres(){
        List<RequestTitreJpaEntity> results = requestTitreRepository.findAll();
        RequestTitreJpaEntity result = results.get(0);
        RequestTitre titre = new RequestTitre(result.getName(), result.getSlug(), result.getCapacite(), result.getValidityDurationInYears());
        System.out.println(titre);
        return titre;
    }

}
