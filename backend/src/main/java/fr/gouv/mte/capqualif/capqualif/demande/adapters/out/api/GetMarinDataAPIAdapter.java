package fr.gouv.mte.capqualif.capQualif.demande.adapters.out.api;

import fr.gouv.mte.capqualif.capQualif.demande.adapters.out.api.dto.MarinDto;
import fr.gouv.mte.capqualif.capQualif.demande.adapters.out.api.dto.TitreOfMarinDto;
import fr.gouv.mte.capqualif.capQualif.demande.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.capQualif.demande.domain.marin.Marin;
import fr.gouv.mte.capqualif.capQualif.demande.domain.marin.TitreOfMarin;
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

    String ADMINISTRES_API_URL = "***REMOVED***" +
            "***REMOVED***";
    String ADMINISTRES_API_URL_MOCK = "***REMOVED***";

    String ITEM_API_URL = "***REMOVED***";
    String ITEM_API_URL_MOCK = "***REMOVED***";

    @Override
    public Marin getMarin(String numeroDeMarin) {
        // Let's get all titres of a marin and convert the data into something suitable for the domain of our architecture hexagon!
        List<TitreOfMarinDto> allTitresOfMarinDto = jsonGetter.getTitresOfMarinDtoFromAPI(numeroDeMarin,
                ITEM_API_URL_MOCK);
        List<TitreOfMarin> allTitresOfMarin = titreOfMarinMapper.mapToDomainEntitiesList(allTitresOfMarinDto);

        // Let's go the same for all marin basic data (name, address, etc.)!
        MarinDto marinDto = jsonGetter.getMarinDtoFromAPI(numeroDeMarin, ADMINISTRES_API_URL_MOCK);
        Marin marin = marinMapper.mapToDomaineEntity(marinDto);

        // Let's wire titres to marin
        marin.setAllTitresOfMarin(allTitresOfMarin);

        return marin;
    }
}
