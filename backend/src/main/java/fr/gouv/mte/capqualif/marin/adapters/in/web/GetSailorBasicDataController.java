package fr.gouv.mte.capqualif.marin.adapters.in.web;

import fr.gouv.mte.capqualif.marin.application.ports.in.GetSailorBasicDataUseCase;
import fr.gouv.mte.capqualif.marin.domain.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marins")
@CrossOrigin(origins = "http://localhost:3000")
public class GetSailorBasicDataController {

    @Autowired
    private GetSailorBasicDataUseCase getSailorBasicDataUseCase;

    @GetMapping("/{numeroDeMarin}")
    public Sailor getSailorBasicData (@PathVariable("numeroDeMarin") String numeroDeMarin) {
        return getSailorBasicDataUseCase.getSailorBasicData(numeroDeMarin);
    }
}
