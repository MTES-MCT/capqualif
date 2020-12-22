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

        List<ConditionTitre> conditions = getConditionTitres(titreId);

        List<CompareResult> compareResults = new ArrayList<CompareResult>();

        for (ConditionTitre condition : conditions) {

            // find the json with the matching main key (identifier) at any level
            //      load all marin data json from api
            //      find matching portion of the json
            //      return the complete set of data from the matching portion

//            List<Map> allMatchingData = getMarinDataPort.getMarinData(condition.getExistingDataSource(), numeroDeMarin);


            // get additional validity values for this object
            //      take the set of data
            //      check all data (minus the main key?) validity values

//            List<Map> allMatchingData = dataFinder.findMatchingMarinData(condition.getExistingDataSource(), numeroDeMarin);
//            boolean result = dataChecker.compareDataToCondition(allMatchingData, condition, LocalDate.now());
//            CompareResult compareResult = new CompareResult(condition.getLibelle(), result);
//            compareResults.add(compareResult);
        }
        return compareResults;
    }

    private List<ConditionTitre> getConditionTitres(String titreId) {
        Titre titre = getTitlePort.getTitle(titreId);
        List<ConditionTitre> conditions = titre.getConditions();
        return conditions;
    }


}
