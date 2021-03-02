package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class ExistingDataSourceMock implements ExistingDataSource {

    public DataToExtractFromExistingDataSource findByConditionValue(ConditionTitre conditionTitre) {
        switch (conditionTitre.getMainValueToCheck().getValueExpressedInLegalTerms()) {
            case "Âge supérieur ou égal à 16 ans":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "dateNaissance", DataType.DATE),
                                        null,
                                DataType.DATE),
                        null
                );
            case "Aptitude toutes fonctions, toutes navigations":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelle",
                                        DataType.STRING),
                                new ValueInExistingDataSource("Apte TF/TN"), DataType.STRING
                        ),
                        Arrays.asList(new KeyInExistingDataSource(
                                // TO DO : I don't like the juridicalName being hard coded. Replace.
                                "Date de fin de validité",
                                "dateFinDeValidite",
                                DataType.DATE))
                );
            case "Module P1-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING),
                                new ValueInExistingDataSource("P1–Appui-Navigation"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE)
                        )
                );
            case "Module P2-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING),
                                new ValueInExistingDataSource("P2–Appui-Manutention/arrimage cargaison/pêche"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE)
                        )
                );
            case "Module P3-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING
                                ),
                                new ValueInExistingDataSource("P3–Appui-Exploitation/assist/entretien/répar"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE)
                        )
                );
            case "Module NP-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING
                                ),
                                new ValueInExistingDataSource("NP–Appui-Module Nation Pont"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE)
                        )
                );
            case "Certificat de formation de base à la sécurité (CFBS)":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ITEM,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelle",
                                        DataType.STRING,
                                        true,
                                        Collections.singletonList(
                                                new ParentKey(Position.POSITION_1, "codeBrevetMarin")
                                        )
                                ),
                                new ValueInExistingDataSource(
                                        "Certificat de formation de base à la sécurité (STCW10)"
                                ), DataType.STRING
                        ),
                        Arrays.asList(
                                new KeyInExistingDataSource(
                                        "Statut",
                                        "libelle",
                                        DataType.STRING,
                                        true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                                ),
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateExpiration",
                                        DataType.DATE)
                        )
                );
            default:
                return null;
        }
    }
}
