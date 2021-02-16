package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.BipUseCase;
import org.springframework.stereotype.Component;

@Component
public class BipService implements BipUseCase {

    public String sayYes() {
        return "Yes";
    }

}
