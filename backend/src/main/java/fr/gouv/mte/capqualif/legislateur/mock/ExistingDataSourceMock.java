package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class ExistingDataSourceMock implements ExistingDataSource {

    public DataToExtractFromExistingDataSource findByConditionValue(String conditionValue) {
        switch (conditionValue) {
            case "Âge supérieur ou égal à 16 ans":
                return new DataToExtractFromExistingDataSource(
                        "Âge minimum",
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new EntryInExistingDataSource(new KeyInExistingDataSource("dateNaissance"),
                                null, DataType.DATE),
                        null
                );
            case "Aptitude toutes fonctions, toutes navigations":
                return new DataToExtractFromExistingDataSource(
                        "Aptitude médicale",
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelle"),
                                new Value("Apte TF/TN"), DataType.STRING
                        ),
                        Arrays.asList(new KeyInExistingDataSource("dateFinDeValidite"))
                );
            case "Module P1-Appui":
                return new DataToExtractFromExistingDataSource(
                        "Aptitude médicale",
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv"),
                                new Value("P1–Appui-Navigation"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Module P2-Appui":
                return new DataToExtractFromExistingDataSource(
                        "Formation modulaire : Module P2-Appui",
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv"),
                                new Value("P2–Appui-Manutention/arrimage cargaison/pêche"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Module P3-Appui":
                return new DataToExtractFromExistingDataSource(
                        "Formation modulaire : Module P3-Appui",
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv"),
                                new Value("P3–Appui-Exploitation/assist/entretien/répar"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Module NP-Appui":
                return new DataToExtractFromExistingDataSource(
                        "Formation modulaire : Module NP-Appui",
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv"),
                                new Value("NP–Appui-Module Nation Pont"),DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Certificat de formation de base à la sécurité (CFBS)":
                return new DataToExtractFromExistingDataSource(
                        "Certificat de formation de base à la sécurité (CFBS)",
                        ExistingDataSourceName.ITEM,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelle", true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"
                                        ))),
                                new Value(
                                        "Certificat de formation de base à la sécurité (STCW10)"
                                ), DataType.STRING
                        ),
                        Arrays.asList(
                                new KeyInExistingDataSource("dateExpiration", DataType.DATE),
                                new KeyInExistingDataSource(
                                        "libelle",
                                        DataType.STRING,
                                        true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                                )
                        )
                );
            default:
                return null;
        }
    }
}
