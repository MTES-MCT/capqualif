package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.AdministresDto;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.AmforeDto;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.ApiDataDto;
import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.EsculapeDto;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Age;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.AptitudeMedicale;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.Formation;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.MarinData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructionMapper {

    public List<MarinData> mapListToDomainEntityList(List<ApiDataDto> dtos) {
        List<MarinData> marinDataList = new ArrayList<>();
        for (ApiDataDto dto : dtos) {
            marinDataList.add(mapToDomainEntity(dto));
        }
        return marinDataList;
    }

    private MarinData mapToDomainEntity(ApiDataDto dto) {
        switch (dto.getName()) {
            case ESCULAPE:
                EsculapeDto specificEsculapeDto = (EsculapeDto) dto;
                return new AptitudeMedicale(
                        specificEsculapeDto.getDecisionMedicale().getCode(),
                        specificEsculapeDto.getDateFinDeValidite()
                );
            case ADMINISTRES:
                AdministresDto specificAdministresDto = (AdministresDto) dto;
                return new Age(
                        specificAdministresDto.getDateNaissance()
                );
            case AMFORE:
                AmforeDto specificAmforeDto = (AmforeDto) dto;
                return new Formation(
                        specificAmforeDto.getLibelleModuleUv(),
                        specificAmforeDto.getDateAcquisition()
                );
            case ITEM:
                /**
                 * TODO: make entity
                 */
                return null;
            default:
                return null;
        }
    }

}

//    public AptitudeMedicale mapToDomainEntity(EsculapeDTO dto) {
//        return new AptitudeMedicale(
//                dto.getDateFinDeValidite(),
//                dto.getDecisionMedicale().getCode()
//        );
//    }


