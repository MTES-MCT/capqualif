package fr.gouv.mte.capqualif.marin.adapters.in.web;

import fr.gouv.mte.capqualif.marin.application.ports.in.GetMarinBasicDataUseCase;
import fr.gouv.mte.capqualif.marin.domain.marin.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marins")
@CrossOrigin
public class GetMarinBasicDataController {

    @Autowired
    private GetMarinBasicDataUseCase getMarinBasicDataUseCase;

    @GetMapping("/{numeroDeMarin}")
    public Marin getMarinBasicData(@PathVariable("numeroDeMarin") String numeroDeMarin) {
        return getMarinBasicDataUseCase.getMarinBasicData(numeroDeMarin);
    }
}
