package fr.gouv.mte.capqualif.marin.adapters.out.api;

import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.TitreOfMarinDto;
import fr.gouv.mte.capqualif.marin.domain.marin.TitreOfMarin;
import fr.gouv.mte.capqualif.titre.domain.Titre;
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
        TitreOfMarin titreOfMarin = new TitreOfMarin(
                titreOfMarinDto.getNumeroTitre(),
                titreOfMarinDto.getCodeBrevetMarinDTO().getLibelle(),
                titreOfMarinDto.getDateDelivrance(),
                titreOfMarinDto.getDateRevalidation(),
                titreOfMarinDto.getDateEffet(),
                titreOfMarinDto.getDateExpiration(),
                titreOfMarinDto.getCodeEtatTitreDTO().getLibelle(),
                titreOfMarinDto.getCodeAutoriteDelivranceDTO().getLibelle(),
                titreOfMarinDto.getListTitreCapacite()
        );
        return titreOfMarin;
    }
}