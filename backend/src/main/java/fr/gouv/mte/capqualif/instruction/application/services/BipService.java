package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.in.BipUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BipService implements BipUseCase {

    private BipCollaborator bipCollaborator;

    @Autowired
    public BipService(BipCollaborator bipCollaborator) {
        this.bipCollaborator = bipCollaborator;
    }

    public String sayYes() {
        return bipCollaborator.returnName() + ", yes";
    }

}
