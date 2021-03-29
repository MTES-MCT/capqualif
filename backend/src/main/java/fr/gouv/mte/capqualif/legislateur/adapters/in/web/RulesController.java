package fr.gouv.mte.capqualif.legislateur.adapters.in.web;

import fr.gouv.mte.capqualif.legislateur.application.services.ParseService;
import fr.gouv.mte.capqualif.legislateur.domain.Operation;
import fr.gouv.mte.capqualif.legislateur.domain.OperationType;
import fr.gouv.mte.capqualif.legislateur.domain.Operations;
import fr.gouv.mte.capqualif.legislateur.domain.SubOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/legislateur")
@CrossOrigin(origins = "http://localhost:3000")
public class RulesController {

    @Autowired
    private ParseService parseService;

    public RulesController(ParseService parseService) {
        this.parseService = parseService;
    }

    @PostMapping("/conditions")
    public void createConditions(@RequestBody Operations operations) {
        parseService.createConditions(operations);
    }

}