package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.*;
import fr.gouv.mte.capqualif.capqualif.instruction.domain.*;
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
                ItemDto specificItemDto = (ItemDto) dto;
                return new Titre(
                        specificItemDto.getCodeBrevetMarin().getLibelle(),
                        specificItemDto.getDateExpiration(),
                        specificItemDto.getCodeEtatTitre().getCode()
                );
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


