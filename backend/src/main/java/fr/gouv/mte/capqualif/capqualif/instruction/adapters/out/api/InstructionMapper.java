package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.APINames;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.AptitudeMedicale;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.MarinDataNames;
import org.springframework.stereotype.Component;

@Component
public class InstructionMapper {

    public AptitudeMedicale mapToDomainEntity(EsculapeDTO dto) {
        return new AptitudeMedicale(
                dto.getDateFinDeValidite(),
                dto.getDecisionMedicale().getCode()
        );
    }

    public String mapToDomainMarinDataNames(APINames APIName) {
        switch(APIName) {
            case ADMINISTRES:
                return MarinDataNames.ADMINISTRES.getName();
            case ESCULAPE:
                return MarinDataNames.ESCULAPE.getName();
            case AMFORE:
                return MarinDataNames.AMFORE.getName();
            case ITEM:
                return MarinDataNames.ITEM.getName();
            default:
                return "";
        }
    }

}
