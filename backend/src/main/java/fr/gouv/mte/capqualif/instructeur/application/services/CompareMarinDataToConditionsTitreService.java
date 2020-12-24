package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.instructeur.adapters.out.api.DataFinder;
import fr.gouv.mte.capqualif.instructeur.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instructeur.domain.CompareResult;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CompareMarinDataToConditionsTitreService implements CompareMarinDataToConditionsTitreUseCase {

    @Autowired
    GetTitlePort getTitlePort;

    @Autowired
    GetMarinDataPort getMarinDataPort;

    @Autowired
    DataFinder dataFinder;

    @Autowired
    DataChecker dataChecker;


    @Override
    public List<CompareResult> compareMarinDataToConditionsTitre(String titreId, String numeroDeMarin) {

        List<CompareResult> compareResults = new ArrayList<CompareResult>();

        // Retrieve titre to know what conditions to check
        Titre titre = getTitlePort.getTitle(titreId);
        List<ConditionTitre> conditions = titre.getConditions();

        // For each condition, check if marin data are valid and save the result
        for (ConditionTitre condition : conditions) {
            List<Map> allMatchingData = dataFinder.findMatchingMarinData(condition.getExistingDataSource(), numeroDeMarin);
            boolean result = dataChecker.compareDataToCondition(allMatchingData, condition, LocalDate.now());
            CompareResult compareResult = new CompareResult(condition.getLibelle(), result);
            compareResults.add(compareResult);
        }
        return compareResults;
    }

}