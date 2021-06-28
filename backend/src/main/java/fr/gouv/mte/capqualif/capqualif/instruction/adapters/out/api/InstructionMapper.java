package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.AdministresDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDTO;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Age;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.AptitudeMedicale;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.MarinData;
import org.springframework.stereotype.Component;

@Component
public class InstructionMapper {

    public MarinData mapToDomainEntity(APIDataDTO dto) {
        switch(dto.getName()) {
            case ESCULAPE:
                EsculapeDTO specificEsculapeDTO = (EsculapeDTO) dto;
                return new AptitudeMedicale(
                        specificEsculapeDTO.getDecisionMedicale().getCode(),
                        specificEsculapeDTO.getDateFinDeValidite()
                );
            case ADMINISTRES:
                AdministresDTO specificAdministresDTO = (AdministresDTO) dto;
                return new Age(
                        specificAdministresDTO.getDateNaissance()
                );
            case AMFORE:
                /**
                 * TODO: make entity
                 */
                return null;
            case ITEM:
                /**
                 * TODO: make entity
                 */
                return null;
            default:
                return null;
        }

    }

//    public AptitudeMedicale mapToDomainEntity(EsculapeDTO dto) {
//        return new AptitudeMedicale(
//                dto.getDateFinDeValidite(),
//                dto.getDecisionMedicale().getCode()
//        );
//    }

}
