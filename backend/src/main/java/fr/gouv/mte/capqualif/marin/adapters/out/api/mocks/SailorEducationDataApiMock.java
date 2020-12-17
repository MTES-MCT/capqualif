package fr.gouv.mte.capqualif.marin.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.marin.domain.SailorEducationData;
import fr.gouv.mte.capqualif.marin.domain.titreMarin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SailorEducationDataApiMock {
    public SailorEducationData findSailorEducationDataBySailorId(String sailorId) {
        List<titreMarin> titlesList = new ArrayList<>();
        List<String> restrictions1 = new ArrayList<String>(Arrays.asList("pas de bras", "pas de chocolat"));
        titlesList.add(new titreMarin(
                "1",
                "CAEERS",
                "29/01/1988",
                "01/01/2004",
                "02/02/2002",
                "02/02/2002",
                "28/02/2025",
                true));
        List<String> restrictions2 = new ArrayList<String>(Arrays.asList("pas de bras", "pas de chocolat"));
        titlesList.add(new titreMarin(
                "2",
                "CGO",
                "20/03/1978",
                "01/01/1994",
                "02/01/1994",
                "28/02/2000",
                "28/02/2025",
                true)
        );

        SailorEducationData sailorEducationData = new SailorEducationData(titlesList);
        return sailorEducationData;
    }

}