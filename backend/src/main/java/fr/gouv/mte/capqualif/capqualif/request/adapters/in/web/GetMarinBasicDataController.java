package fr.gouv.mte.capqualif.capqualif.request.adapters.in.web;

import fr.gouv.mte.capqualif.capqualif.request.application.ports.in.GetMarinBasicDataUseCase;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marins")
@CrossOrigin(origins = "http://localhost:3000")
public class GetMarinBasicDataController {

    @Autowired
    private GetMarinBasicDataUseCase getMarinBasicDataUseCase;

    @GetMapping("/{numeroDeMarin}")
    public Marin getMarinBasicData(@PathVariable("numeroDeMarin") String numeroDeMarin) {
        return getMarinBasicDataUseCase.getMarinBasicData(numeroDeMarin);
    }
}
