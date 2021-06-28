package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.AptitudeMedicale;
import org.springframework.stereotype.Component;

@Component
public class InstructionMapper {

    public AptitudeMedicale mapToDomaineEntity(EsculapeDTO dto) {
        return new AptitudeMedicale(
                dto.getDateFinDeValidite(),
                dto.getDecisionMedicale().getCode()
        );
    }
}
