package fr.gouv.mte.capqualif.titre.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.titre.domain.*;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TitresApiMock {

    public List<Titre> findAll() {
        return buildTitresList();
    }

    public Titre findTitreById(String id) {
        List<Titre> titresList = buildTitresList();
        for (Titre titre : titresList) {
            if (titre.getId().equals(id)) {
                return titre;
            }
        }
        return null;
    }

    private List<Titre> buildTitresList() {
        List<Titre> titresList = new ArrayList<>();
        List<ConditionTitre> conditions = new ArrayList<ConditionTitre>
            (Arrays.asList
                (
                    new ConditionTitre("age minimum", new Value(LocalDate.now().minusYears(16).toString(), DataType.DATE), ComparisonRule.BIGGER_THAN, ExistingDataSourceName.ADMINISTRES),
                    new ConditionTitre("aptitude médicale", new Value("Apte TF/TN", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.ESCULAPE),
                    new ConditionTitre("formation modulaire : Module P1-Appui", new Value("P1–Appui-Navigation", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.AMFORE),
                    new ConditionTitre("formation modulaire : Module P2-Appui", new Value("P2–Appui-Manutention/arrimage cargaison/pêche", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.AMFORE),
                    new ConditionTitre("formation modulaire : Module P3-Appui", new Value("P3–Appui-Exploitation/assist/entretien/répar", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.AMFORE),
                    new ConditionTitre("formation modulaire : Module NP-Appui", new Value("NP–Appui-Module Nation Pont", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.AMFORE),
                    new ConditionTitre("certificat de formation de base à la sécurité (CFBS)", new Value("Certificat de formation de base à la sécurité (STCW10)", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.ITEM)
                )
            );


        List<String> restrictions = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));
//        List<String> restrictions = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));
        titresList.add(new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                conditions,
                restrictions));

        List<ConditionTitre> conditions2 = new ArrayList<ConditionTitre>(Arrays.asList(
                new ConditionTitre("aptitude médicale", new Value("Apte TF/TN", DataType.STRING), ComparisonRule.STRICT_EQUALITY, ExistingDataSourceName.ESCULAPE)));
        List<String> restrictions2 = new ArrayList<String>(Arrays.asList("Cuisson de tartes flambées", "Préparation de crèmes brûlées"));
        titresList.add(new Titre(
                "2",
                "Capitaine 200",
                conditions2,
                restrictions2));

        return titresList;
    }
}