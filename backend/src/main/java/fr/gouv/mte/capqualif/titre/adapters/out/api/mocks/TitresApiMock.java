package fr.gouv.mte.capqualif.titre.adapters.out.api.mocks;

import fr.gouv.mte.capqualif.titre.domain.*;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import org.springframework.stereotype.Component;

import java.util.*;

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

        Date today = new Date(); // A temporary mock until we know what reference event we should use

        List<Titre> titresList = new ArrayList<>();
        List<ConditionTitre> conditions = new ArrayList<ConditionTitre>
            (Arrays.asList
                (
                    new ConditionTitre(
                            "Âge minimum",
                            new Value("Âge supérieur ou égal à 16 ans", ComparisonRule.EQUAL_TO_OR_GREATER_THAN)
                    ),
                    new ConditionTitre(
                            "Aptitude médicale",
                            new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                            Collections.singletonList(new DateValue("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, today))
                    ),
                    new ConditionTitre(
                            "Formation modulaire : Module P1-Appui",
                            new Value("Module P1-Appui",ComparisonRule.STRICT_EQUALITY),
                            Collections.singletonList(new DateValue("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, today))
                    ),
                    new ConditionTitre(
                            "Formation modulaire : Module P2-Appui",
                            new Value("Module P2-Appui",ComparisonRule.STRICT_EQUALITY),
                            Collections.singletonList(new DateValue("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, today))
                    ),
                    new ConditionTitre("Formation modulaire : Module P3-Appui",
                            new Value("Module P3-Appui",ComparisonRule.STRICT_EQUALITY),
                            Collections.singletonList(new DateValue("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, today))
                    ),
                    new ConditionTitre("Formation modulaire : Module NP-Appui",
                            new Value("Module NP-Appui",ComparisonRule.STRICT_EQUALITY),
                            Collections.singletonList(new DateValue("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, today))
                    ),
                    new ConditionTitre("Certificat de formation de base à la sécurité (CFBS)",
                            new Value("Certificat de formation de base à la sécurité (CFBS)", ComparisonRule.STRICT_EQUALITY),
                            Arrays.asList(
                                    new Value("Statut", ComparisonRule.STRICT_EQUALITY),
                                    new DateValue("Date de fin de validité", ComparisonRule.EQUAL_TO_OR_POSTERIOR, today)
                            )
                    )
                )
            );


        List<String> restrictions = new ArrayList<String>(Arrays.asList("Préparation de poires Belle Hélène", "Confection de banana splits"));

        titresList.add(new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                conditions,
                restrictions));

        List<ConditionTitre> conditions2 = new ArrayList<ConditionTitre>(Collections.singletonList(
                new ConditionTitre(
                        "Aptitude médicale",
                        new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY),
                        Collections.singletonList(new DateValue("Date de fin de validité",
                                ComparisonRule.EQUAL_TO_OR_POSTERIOR, today))
                )
        ));
        List<String> restrictions2 = new ArrayList<String>(Arrays.asList("Cuisson de tartes flambées", "Préparation de crèmes brûlées"));
        titresList.add(new Titre(
                "2",
                "Capitaine 200",
                conditions2,
                restrictions2));

        return titresList;
    }
}