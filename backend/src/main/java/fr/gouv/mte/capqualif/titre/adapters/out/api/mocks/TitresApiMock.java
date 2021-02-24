package fr.gouv.mte.capqualif.titre.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.titre.domain.*;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.springframework.stereotype.Component;

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
                    new ConditionTitre("âge minimum", "Âge supérieur ou égal à 16 ans", ComparisonRule.GREATER_THAN),
                    new ConditionTitre("aptitude médicale","Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                    new ConditionTitre("formation modulaire : Module P1-Appui", "Module P1-Appui", ComparisonRule.STRICT_EQUALITY),
                    new ConditionTitre("formation modulaire : Module P2-Appui", "Module P2-Appui", ComparisonRule.STRICT_EQUALITY),
                    new ConditionTitre("formation modulaire : Module P3-Appui", "Module P3-Appui", ComparisonRule.STRICT_EQUALITY),
                    new ConditionTitre("formation modulaire : Module NP-Appui", "Module NP-Appui", ComparisonRule.STRICT_EQUALITY),
                    new ConditionTitre("certificat de formation de base à la sécurité (CFBS)", "Certificat de formation de base à la sécurité (CFBS)", ComparisonRule.STRICT_EQUALITY)
                )
            );


        List<String> restrictions = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));

        titresList.add(new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                conditions,
                restrictions));

        List<ConditionTitre> conditions2 = new ArrayList<ConditionTitre>(Arrays.asList(
                new ConditionTitre("aptitude médicale", "Aptitude toutes fonctions, toutes navigations.", ComparisonRule.STRICT_EQUALITY)));
        List<String> restrictions2 = new ArrayList<String>(Arrays.asList("Cuisson de tartes flambées", "Préparation de crèmes brûlées"));
        titresList.add(new Titre(
                "2",
                "Capitaine 200",
                conditions2,
                restrictions2));

        return titresList;
    }
}