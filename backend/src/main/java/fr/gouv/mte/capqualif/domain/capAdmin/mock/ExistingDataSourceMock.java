package fr.gouv.mte.capqualif.domain.capAdmin.mock;

import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.*;
import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

@Component
public class ExistingDataSourceMock implements ExistingDataSource {

    public CorrespondingDataInExistingDataSource findByConditionValue(ConditionTitre conditionTitre) {
        switch (conditionTitre.getMainValueToCheck().getValueExpressedInLegalTerms()) {
            case "Âge supérieur ou égal à 16 ans":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.ADMINISTRES,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                    conditionTitre.getJuridicalDesignation(),
                                    "dateNaissance", DataType.DATE,
                                    conditionTitre.getMainValueToCheck().getHowToCompare(),
                                    new ComparisonDate(LocalDate.now().minusYears(16))
                                ),
                                null,
                                DataType.DATE),
                        null
                );
            case "Aptitude toutes fonctions, toutes navigations":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelle",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ComparisonString("Apte TF/TN"),
                                        true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "decisionMedicale"))
                                ),
                                new ValueInExistingDataSource("Apte TF/TN"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        // TO DO : I don't like the juridicalName being hard coded. Replace.
                                        "Date de fin de validité",
                                        "dateFinDeValidite",
                                        DataType.DATE,
                                        getHowToCompare(conditionTitre, "Date de fin de validité"),
                                        getComparisonData(conditionTitre, "Date de fin de validité")
                                )
                        )
                );
            case "Module P1-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                    conditionTitre.getJuridicalDesignation(),
                                    "libelleModuleUv",
                                    DataType.STRING,
                                    conditionTitre.getMainValueToCheck().getHowToCompare(),
                                    new ComparisonString("P1–Appui-Navigation")
                                ),
                                new ValueInExistingDataSource("P1–Appui-Navigation"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        getHowToCompare(conditionTitre, "Date de fin de validité"),
                                        getComparisonData(conditionTitre, "Date de fin de validité")
                                )
                        )
                );
            case "Module P2-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ComparisonString("P2–Appui-Manutention/arrimage cargaison/pêche")
                                ),
                                new ValueInExistingDataSource("P2–Appui-Manutention/arrimage cargaison/pêche"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        getHowToCompare(conditionTitre, "Date de fin de validité"),
                                        getComparisonData(conditionTitre, "Date de fin de validité")
                                )
                        )
                );
            case "Module P3-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ComparisonString("P3–Appui-Exploitation/assist/entretien/répar")
                                ),
                                new ValueInExistingDataSource("P3–Appui-Exploitation/assist/entretien/répar"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        getHowToCompare(conditionTitre, "Date de fin de validité"),
                                        getComparisonData(conditionTitre, "Date de fin de validité"))
                        )
                );
            case "Module NP-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ComparisonString("NP–Appui-Module Nation Pont")
                                ),
                                new ValueInExistingDataSource("NP–Appui-Module Nation Pont"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        getHowToCompare(conditionTitre, "Date de fin de validité"),
                                        getComparisonData(conditionTitre, "Date de fin de validité"))
                        )
                );
            case "Certificat de formation de base à la sécurité (CFBS)":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.ITEM,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelle",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ComparisonString("Certificat de formation de base à la sécurité (STCW10)"),
                                        true,
                                        Collections.singletonList(
                                                new ParentKey(Position.POSITION_1, "codeBrevetMarin")
                                        )
                                ),
                                new ValueInExistingDataSource(
                                        "Certificat de formation de base à la sécurité (STCW10)"
                                ),
                                DataType.STRING
                        ),
                        Arrays.asList(
                                new KeyInExistingDataSource(
                                        "Statut",
                                        "libelle",
                                        DataType.STRING,
                                        getHowToCompare(conditionTitre, "Statut"),
                                        getComparisonData(conditionTitre, "Statut"),
                                        true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                                ),
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateExpiration",
                                        DataType.DATE,
                                        getHowToCompare(conditionTitre, "Date de fin de validité"),
                                        getComparisonData(conditionTitre, "Date de fin de validité")
                                )
                        )
                );
            default:
                return null;
        }
    }

    private ComparisonData getComparisonData(ConditionTitre conditionTitre, String valueExpressedInLegalTerms) {
        return Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                .filter(additionalValue -> valueExpressedInLegalTerms.equals(additionalValue.getValueExpressedInLegalTerms()))
                .findFirst().orElse(null)).getComparisonData();
    }

    private ComparisonRule getHowToCompare(ConditionTitre conditionTitre, String valueExpressedInLegalTerms) {
        return Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                .filter(additionalValue -> valueExpressedInLegalTerms.equals(additionalValue.getValueExpressedInLegalTerms()))
                .findFirst().orElse(null)).getHowToCompare();
    }
}
