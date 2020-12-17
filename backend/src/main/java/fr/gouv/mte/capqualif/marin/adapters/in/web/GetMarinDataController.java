package fr.gouv.mte.capqualif.marin.adapters.in.web;

import fr.gouv.mte.capqualif.marin.application.ports.in.GetMarinDataUseCase;
import fr.gouv.mte.capqualif.marin.domain.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sailors")
public class GetMarinDataController {

    @Autowired
    private GetMarinDataUseCase getMarinDataUseCase;

    @GetMapping("/{numeroDeMarin}")
    public Sailor getMarinData (@PathVariable("numeroDeMarin") String numeroDeMarin) {
        return getMarinDataUseCase.getMarinData(numeroDeMarin);
    }
}
