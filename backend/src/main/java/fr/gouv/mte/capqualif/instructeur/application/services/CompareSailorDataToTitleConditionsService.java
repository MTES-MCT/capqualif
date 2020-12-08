package fr.gouv.mte.capqualif.instructeur.application.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instructeur.application.ports.in.CompareSailorDataToTitleConditionsUseCase;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetSailorPort;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetTitlePort;
import fr.gouv.mte.capqualif.instructeur.domain.CompareResult;
import fr.gouv.mte.capqualif.marin.domain.Data;
import fr.gouv.mte.capqualif.marin.domain.Sailor;
import fr.gouv.mte.capqualif.title.domain.ConditionTitre;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class CompareSailorDataToTitleConditionsService implements CompareSailorDataToTitleConditionsUseCase {

    @Autowired
    GetSailorPort getSailorPort;

    @Autowired
    GetTitlePort getTitlePort;

    @Autowired
    DataFinder dataFinder;


    @Override
    public List<CompareResult> compareSailorDataToTitleConditions(String sailorNumber, String titleId) {

        String dummyDate = "2020-12-08";

        Title titre = getTitlePort.getTitle(titleId);
        List<ConditionTitre> conditions = titre.getConditions();

        // {label: condition.getValeur, estValide: checkMatchingDataValidity()}

        DataFinder dataFinder = new DataFinder();

        for (ConditionTitre condition : conditions) {
            dataFinder.findMatchingMarinData(condition.getExistingDataSource(), sailorNumber);
            checkDataValidity(condition.getValeur(), dummyDate);
        }
        return null;
    }


    private boolean checkDataValidity(String conditionValeur, String date) {
        boolean result = false;
        return result;
    }



}
