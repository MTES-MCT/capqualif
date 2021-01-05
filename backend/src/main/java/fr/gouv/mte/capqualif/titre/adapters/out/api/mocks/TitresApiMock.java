package fr.gouv.mte.capqualif.titre.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.titre.domain.ComparisonType;
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
        List<ConditionTitre> conditions = new ArrayList<ConditionTitre>
            (Arrays.asList
                (
//                    new ConditionTitre("age minimum","16", ComparisonType.BIGGER_THAN, "administres"),
//                    new ConditionTitre("aptitude médicale", "Apte TF/TN", ComparisonType.STRICT_EQUALITY, "esculape"),
//                    new ConditionTitre("formation modulaire : Module P1-Appui", "P1–Appui-Navigation", ComparisonType.STRICT_EQUALITY, "amfore"),
//                    new ConditionTitre("formation modulaire : Module P2-Appui", "P2–Appui-Manutention/arrimage cargaison/pêche", ComparisonType.STRICT_EQUALITY, "amfore"),
//                    new ConditionTitre("formation modulaire : Module P3-Appui", "P3–Appui-Exploitation/assist/entretien/répar", ComparisonType.STRICT_EQUALITY, "amfore"),
//                    new ConditionTitre("formation modulaire : Module NP-Appui", "NP–Appui-Module Nation Pont", ComparisonType.STRICT_EQUALITY, "amfore"),
                    new ConditionTitre("certificat de formation de base à la sécurité (CFBS)", "Certificat de formation de base à la sécurité (STCW10)", ComparisonType.STRICT_EQUALITY, "item")
                )
            );

        List<String> prerogatives = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));

        titresList.add(new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                conditions,
                prerogatives));

        List<ConditionTitre> conditions2 = new ArrayList<ConditionTitre>(Arrays.asList(
                new ConditionTitre("aptitude médicale", "Apte TF/TN", ComparisonType.STRICT_EQUALITY, "esculape")));
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