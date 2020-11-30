package fr.gouv.mte.capqualif.title.adapters.in.web;

import fr.gouv.mte.capqualif.title.application.ports.in.GetAllTitlesUseCase;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titles")
@CrossOrigin(origins = "http://localhost:3000")
public class GetAllTitlesController {

    @Autowired
    GetAllTitlesUseCase getAllTitlesUseCase;

    @GetMapping("/titles")
    public List<Title> getAllTitles() {
        return getAllTitlesUseCase.getAllTitles();
    }

}



