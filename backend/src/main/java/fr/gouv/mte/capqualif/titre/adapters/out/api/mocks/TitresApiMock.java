package fr.gouv.mte.capqualif.titre.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TitresApiMock {

    public List<Titre> buildTitresList() {
        List<Titre> titresList = new ArrayList<>();
        List<ConditionTitre> conditionsDumb = new ArrayList<ConditionTitre>(Arrays.asList(new ConditionTitre("a dumb condition", "qui est esse", "egaliteStricte", "dumbSource")));

        List<String> prerogativesDumb = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));

        titresList.add(new Titre(
                "0",
                "Dumb titre",
                conditionsDumb,
                prerogativesDumb));


        List<ConditionTitre> conditions = new ArrayList<ConditionTitre>
            (Arrays.asList
                (
//                    new ConditionTitre("age minimum","16", "minimum", "administres"),
//                    new ConditionTitre("aptitude médicale", "Apte TF/TN", "egaliteStricte", "esculape"),
                    new ConditionTitre("formation modulaire", "P1–Appui-Navigation", "egaliteStricte", "amfore"),
                    new ConditionTitre("formation modulaire", "P2–Appui-Manutention/arrimage cargaison/pêche", "egaliteStricte", "amfore"),
                    new ConditionTitre("formation modulaire", "P3–Appui-Exploitation/assist/entretien/répar", "egaliteStricte", "amfore"),
                    new ConditionTitre("formation modulaire", "NP–Appui-Module Nation Pont", "egaliteStricte", "amfore")
                )
            );


//                new ConditionTitre("Apte TF/TN", "esculape"))); TO DO : conditions AMFORE - faire une nouvelle condition par module ou une liste de modules ?

        List<String> prerogatives = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));

        titresList.add(new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                conditions,
                prerogatives));

        List<ConditionTitre> conditions2 = new ArrayList<ConditionTitre>(Arrays.asList(
                new ConditionTitre("aptitude médicale", "Apte TF/TN", "egaliteStricte", "esculape")));
        List<String> prerogatives2 = new ArrayList<String>(Arrays.asList("Cuisson de tartes flambées", "Préparation de crèmes brûlées"));
        titresList.add(new Titre(
                "2",
                "Capitaine 200",
                conditions2,
                prerogatives2));

        return titresList;
    }

    public List<Titre> findAll() {
        List<Titre> titlesList = buildTitresList();
        return titlesList;
    }

    public Titre findTitleById(String id) {
        List<Titre> titlesList = buildTitresList();
        for (Titre titre : titlesList) {
            if (titre.getId().equals(id)) {
                return titre;
            }
        }
        return null;
    }
}