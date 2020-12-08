package fr.gouv.mte.capqualif.title.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.title.domain.ConditionTitre;
import fr.gouv.mte.capqualif.title.domain.Title;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TitlesApiMock {

    public List<Title> buildTitlesList() {
        List<Title> titlesList = new ArrayList<>();
        List<ConditionTitre> conditions = new ArrayList<ConditionTitre>(Arrays.asList(
                new ConditionTitre("16", "administres"),
                new ConditionTitre("Apte", "esculape")));

        List<String> prerogatives1 = new ArrayList<String>(Arrays.asList("Fonctions d'appui sur le pont", "Confection de banana splits"));
        titlesList.add(new Title(
                "1",
                "Matelot Pont",
                conditions,
                prerogatives1));

//        List<String> criteria2 = new ArrayList<String>(Arrays.asList("Brevet de matelot Pont", "CFBS", "aptitude médicale"));
//        List<String> prerogatives2 = new ArrayList<String>(Arrays.asList("Fonctions de commandes sur le pont", "Préparation de crèmes brûlées"));
//        titlesList.add(new Title(
//                "2",
//                "Capitaine 200",
//                criteria2,
//                prerogatives2));
        return titlesList;
    }

    public List<Title> findAll() {
        List<Title> titlesList = buildTitlesList();
        return titlesList;
    }

    public Title findTitleById(String id) {
        List<Title> titlesList = buildTitlesList();
        for (Title title : titlesList) {
            if (title.getId().equals(id)) {
                return title;
            }
        }
        return null;
    }
}