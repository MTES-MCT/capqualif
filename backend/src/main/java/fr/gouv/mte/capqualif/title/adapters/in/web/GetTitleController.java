package fr.gouv.mte.capqualif.title.adapters.in.web;

import fr.gouv.mte.capqualif.title.application.ports.in.GetTitleUseCase;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titles")
@CrossOrigin(origins = "http://localhost:3000")
public class GetTitleController {

    @Autowired
    GetTitleUseCase getTitleUseCase;

    @GetMapping("/{titleId}")
    public Title getTitle(@PathVariable("titleId") String titleId) {
        return getTitleUseCase.getTitle(titleId);
    }

}
