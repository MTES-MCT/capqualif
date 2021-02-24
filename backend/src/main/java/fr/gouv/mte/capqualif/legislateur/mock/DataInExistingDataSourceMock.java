package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DataInExistingDataSourceMock implements ExistingDataSource {

    public DataToExtractFromExistingDataSource findByConditionValue(String conditionValue) {
        switch (conditionValue) {
            case "Âge supérieur ou égal à 16 ans":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new EntryInExistingDataSource(new KeyInExistingDataSource("dateNaissance", DataType.DATE),
                                null),
                        null
                );
            case "Aptitude toutes fonctions, toutes navigations":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelle", DataType.STRING),
                                new Value("Apte TF/TN", DataType.STRING)
                        ),
                        Arrays.asList(new KeyInExistingDataSource("dateFinDeValidite", DataType.DATE))
                );
            case "Module P1-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("P1–Appui-Navigation", DataType.STRING)
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Module P2-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("P2–Appui-Manutention/arrimage cargaison/pêche", DataType.STRING)
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Module P3-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("P3–Appui-Exploitation/assist/entretien/répar", DataType.STRING)
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Module NP-Appui":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("NP–Appui-Module Nation Pont", DataType.STRING)
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource("dateFinValidite", DataType.DATE)
                        )
                );
            case "Certificat de formation de base à la sécurité (CFBS)":
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ITEM,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelle", DataType.STRING, true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"
                                        ))),
                                new Value(
                                        "Certificat de matelot pont (2015)",
                                        DataType.STRING
                                )
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
