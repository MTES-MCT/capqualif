package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.instructeur.application.ports.in.CompareMarinDataToConditionsTitreUseCase;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetSailorPort;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.instructeur.domain.CompareResult;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompareMarinDataToConditionsTitreService implements CompareMarinDataToConditionsTitreUseCase {

    @Autowired
    GetSailorPort getSailorPort;

    @Autowired
    GetTitlePort getTitlePort;

    @Autowired
    GetMarinDataPort getMarinDataPort;

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
            List<String> data = getMarinDataPort.findMatchingMarinData(condition.getExistingDataSource(), numeroDeMarin);
            boolean result = dataChecker.checkDataValidity(data, condition.getValeur(), LocalDate.now());
            CompareResult compareResult = new CompareResult(condition.getValeur(), result);
            compareResults.add(compareResult);
        }
        return compareResults;
    }

}
