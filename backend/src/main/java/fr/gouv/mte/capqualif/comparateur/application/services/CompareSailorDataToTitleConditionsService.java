package fr.gouv.mte.capqualif.comparateur.application.services;

import fr.gouv.mte.capqualif.comparateur.application.ports.in.CompareSailorDataToTitleConditionsUseCase;
import fr.gouv.mte.capqualif.comparateur.application.ports.out.GetSailorPort;
import fr.gouv.mte.capqualif.comparateur.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.comparateur.domain.CompareResult;
import fr.gouv.mte.capqualif.sailor.domain.Sailor;
import fr.gouv.mte.capqualif.sailor.domain.titreMarin;
import fr.gouv.mte.capqualif.title.domain.ConditionTitre;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompareSailorDataToTitleConditionsService implements CompareSailorDataToTitleConditionsUseCase {

    @Autowired
    GetSailorPort getSailorPort;

    @Autowired
    GetTitlePort getTitlePort;

    @Override
    public CompareResult compareSailorDataToTitleConditions(String sailorNumber, String titleId) {

        Sailor sailor = getSailorPort.getSailor(sailorNumber);
        Title title = getTitlePort.getTitle(titleId);

        List<ConditionTitre> conditions = title.getConditions();
        List<titreMarin> titreMarins = sailor.getSailorEducationData().getTitles();
        CompareResult result = new CompareResult();

        for (ConditionTitre condition : conditions) {
            for (titreMarin titreMarin : titreMarins) {
//                if (criter === sail)
            }
        }

        return null;
    }
}
