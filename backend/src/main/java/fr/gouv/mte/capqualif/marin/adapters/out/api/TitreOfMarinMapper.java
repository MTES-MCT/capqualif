package fr.gouv.mte.capqualif.marin.adapters.out.api;

import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.TitreCapaciteRest;
import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.TitreOfMarinDto;
import fr.gouv.mte.capqualif.marin.domain.marin.TitreOfMarin;
import fr.gouv.mte.capqualif.marin.domain.marin.TitreOfMarinDates;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class TitreOfMarinMapper {

    List<TitreOfMarin> mapToDomainEntitiesList(List<TitreOfMarinDto> listTitreOfMarinDto) {
        List<TitreOfMarin> listTitresOfMarin = new ArrayList<TitreOfMarin>();
        for (TitreOfMarinDto titreOfMarinDto : listTitreOfMarinDto) {
            TitreOfMarin titreOfMarin = mapToDomainEntity(titreOfMarinDto);
            listTitresOfMarin.add(titreOfMarin);
        }
        return listTitresOfMarin;
    }

    private TitreOfMarin mapToDomainEntity(TitreOfMarinDto titreOfMarinDto) {
        List<String> restrictionsInStandardFormat = new ArrayList<>();
        List<String> restrictionsInStandardFormatEnglish = new ArrayList<>();
        List<String> restrictionInFreeFormat = new ArrayList<>();
        List<String> restrictionInFreeFormatEnglish = new ArrayList<>();
        String capacite = "";
        String capaciteEnglish = "";
        for (TitreCapaciteRest titreCapaciteRest : titreOfMarinDto.getListTitreCapacite()) {
            restrictionsInStandardFormat.add(titreCapaciteRest.getCodeFrmTitreCapaciteRestrictionDTO().getLibelle());
            restrictionsInStandardFormatEnglish.add(titreCapaciteRest.getCodeFrmTitreCapaciteRestrictionDTO().getLibelleAnglais());
            restrictionInFreeFormat.add(titreCapaciteRest.getRestrictionLibre());
            restrictionInFreeFormatEnglish.add(titreCapaciteRest.getRestrictionLibreAnglais());
            capacite = titreCapaciteRest.getCodeFrmTitreCapaciteStwcDTO().getLibelle();
            capaciteEnglish = titreCapaciteRest.getCodeFrmTitreCapaciteStwcDTO().getLibelleAnglais();
        }
        TitreOfMarin titreOfMarin = new TitreOfMarin(
                titreOfMarinDto.getIdIteTitreDetenu(),
                titreOfMarinDto.getNumeroTitre(),
                titreOfMarinDto.getCodeBrevetMarinDTO().getLibelle(),
                new TitreOfMarinDates(
                        titreOfMarinDto.getDateDelivrance(),
                        titreOfMarinDto.getDateRevalidation(),
                        titreOfMarinDto.getDateEffet(),
                        titreOfMarinDto.getDateExpiration()
                ),
                capacite,
                capaciteEnglish,
                titreOfMarinDto.getCodeEtatTitreDTO().getLibelle(),
                titreOfMarinDto.getCodeAutoriteDelivranceDTO().getLibelle(),
                restrictionsInStandardFormat,
                restrictionsInStandardFormatEnglish,
                restrictionInFreeFormat,
                restrictionInFreeFormatEnglish
        );
        return titreOfMarin;
    }
}