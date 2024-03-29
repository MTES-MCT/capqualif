package fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api;

import fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api.dto.MarinDto;
import fr.gouv.mte.capqualif.capqualif.demande.adapters.out.api.dto.TitreOfMarinDto;
import fr.gouv.mte.capqualif.capqualif.demande.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capqualif.demande.domain.marin.Marin;
import fr.gouv.mte.capqualif.capqualif.demande.domain.marin.TitreOfMarin;
import fr.gouv.mte.capqualif.shared.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GetMarinDataAPIAdapter implements GetMarinDataPort {

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
        // Let's get all titres of a marin and convert the data into something suitable for the domain of our architecture hexagon!
        List<TitreOfMarinDto> allTitresOfMarinDto = jsonGetter.getTitresOfMarinDtoFromAPI(numeroDeMarin,
                ITEM_API_URL);
        List<TitreOfMarin> allTitresOfMarin = titreOfMarinMapper.mapToDomainEntitiesList(allTitresOfMarinDto);

        // Let's go the same for all marin basic data (name, address, etc.)!
        MarinDto marinDto = jsonGetter.getMarinDtoFromAPI(numeroDeMarin, ADMINISTRES_API_URL);
        Marin marin = marinMapper.mapToDomaineEntity(marinDto);

        // Let's wire titres to marin
        marin.setAllTitresOfMarin(allTitresOfMarin);

        return marin;
    }
}
