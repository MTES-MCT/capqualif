package fr.gouv.mte.capqualif.sailor.adapters.in.web;

import fr.gouv.mte.capqualif.sailor.application.ports.in.GetSailorBasicDataUseCase;
import fr.gouv.mte.capqualif.sailor.domain.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sailors")
@CrossOrigin(origins = "http://localhost:3000")
public class GetSailorBasicDataController {

    @Autowired
    private GetSailorBasicDataUseCase getSailorBasicDataUseCase;

    @GetMapping("/{sailorNumber}")
    public Sailor getSailorBasicData (@PathVariable("sailorNumber") String id) {
        return getSailorBasicDataUseCase.getSailorBasicData(id);
    }
}
