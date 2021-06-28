package fr.gouv.mte.capqualif.capqualif.request.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto.APIDataDTO;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.MarinDto;
import fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto.TitreOfMarinDto;
import fr.gouv.mte.capqualif.capqualif.request.application.ports.out.GetMarinBasicDataPort;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.Marin;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.TitreOfMarin;
import fr.gouv.mte.capqualif.shared.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetMarinBasicBasicDataAPIAdapter implements GetMarinBasicDataPort {

    @Autowired
    JsonGetter jsonGetter;

    @Autowired
    MarinMapper marinMapper;

    @Autowired
    TitreOfMarinMapper titreOfMarinMapper;

    String ADMINISTRES_API_URL = System.getenv("ADMINISTRES_API_URL");

    String ITEM_API_URL = System.getenv("ITEM_API_URL");
    @Override
    public Marin getMarin(String numeroDeMarin) {
        // Let's get all titres of a marin and convert the data into domain entities
        List<TitreOfMarinDto> allTitresOfMarinDto = jsonGetter.getTitresOfMarinDtoFromAPI(numeroDeMarin,
                ITEM_API_URL);
        List<TitreOfMarin> allTitresOfMarin = titreOfMarinMapper.mapToDomainEntitiesList(allTitresOfMarinDto);

        // Let's do the same for all marin basic data (name, address, etc.)
        APIDataDTO marinDto = jsonGetter.getDtoFromAPI(numeroDeMarin, ADMINISTRES_API_URL, "MarinDto");
        Marin marin = marinMapper.mapToDomaineEntity((MarinDto) marinDto);

        // Let's wire titres to marin
        marin.setAllTitresOfMarin(allTitresOfMarin);

        return marin;
    }
}
