package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class ConditionTitreToRealDataInExistingDataSourcesMapper {

    public List<DataToExtractFromExistingDataSource> whatExistingDataToSearchFor(ExistingDataSourceName existingDataSourceName) {
        switch (existingDataSourceName) {
            case ADMINISTRES:
                return Collections.singletonList(new DataToExtractFromExistingDataSourceWhenWeDontSearchForAValue(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new KeyInExistingDataSource("dateNaissance", DataType.DATE)
                ));

//              "***REMOVED******REMOVED***",
//

            case ESCULAPE:

                // Infos for additonal keys
                KeyInExistingDataSource esculapeAdditionalWantedKey = new KeyInExistingDataSource("dateFinDeValidite"
                        , DataType.DATE);
                List<KeyInExistingDataSource> esculapeAdditionalWantedKeys = new ArrayList<>();
                esculapeAdditionalWantedKeys.add(esculapeAdditionalWantedKey);

                // All infos
                return Collections.singletonList(
                        new DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(
                                ExistingDataSourceName.ESCULAPE,
                                "***REMOVED***",
                                esculapeAdditionalWantedKeys,
                                new EntryInExistingDataSource(
                                        new KeyInExistingDataSource("libelle", DataType.STRING, true,
                                                Arrays.asList(new ParentKey(Position.POSITION_1, "decisionMedicale"))),
                                        new Value("Apte TF/TN", DataType.STRING)
                                )
                        )
                );


//              "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/",

            case AMFORE:

                // Infos for additonal keys
                KeyInExistingDataSource amforeAdditionalWantedKey =
                        new KeyInExistingDataSource("dateFinValidite", DataType.DATE);
                List<KeyInExistingDataSource> amforeAdditionalWantedKeys =
                        new ArrayList<KeyInExistingDataSource>();
                amforeAdditionalWantedKeys.add(amforeAdditionalWantedKey);

                // All infos
                List<DataToExtractFromExistingDataSource> data = new ArrayList<DataToExtractFromExistingDataSource>();
                data.add(new DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        amforeAdditionalWantedKeys,
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("P1–Appui-Navigation", DataType.STRING)
                        )
                ));
                data.add(new DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        amforeAdditionalWantedKeys,
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("P2–Appui-Manutention/arrimage cargaison/pêche", DataType.STRING)
                        )
                ));
                data.add(new DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        amforeAdditionalWantedKeys,
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("P3–Appui-Exploitation/assist/entretien/répar", DataType.STRING)
                        )
                ));
                data.add(new DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        amforeAdditionalWantedKeys,
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                                new Value("NP–Appui-Module Nation Pont", DataType.STRING)
                        )
                ));

                return data;

//              "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/",

            case ITEM:

                // ================= Additional wanted keys =================

                KeyInExistingDataSource itemAdditionalWantedKey1 =
                        new KeyInExistingDataSource("dateExpiration", DataType.DATE);

                KeyInExistingDataSource itemAdditionalWantedKey2 =
                        new KeyInExistingDataSource(
                                "libelle",
                                DataType.STRING,
                                true,
                                Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                        );

                // For testing purpose

//                Key itemAdditionalWantedKey3 = new Key("testKey", "ceQueJeVeuxKey", true,
//                        Arrays.asList(
//                                new ParentKey(Position.POSITION_1, "codeEtatTitre"),
//                                new ParentKey(Position.POSITION_2, "codeExport"),
//                                new ParentKey(Position.POSITION_3, "niveau1"),
//                                new ParentKey(Position.POSITION_4, "niveau2")));

                List<KeyInExistingDataSource> itemAdditionalWantedKeys = new ArrayList<KeyInExistingDataSource>();
                itemAdditionalWantedKeys.add(itemAdditionalWantedKey1);
                itemAdditionalWantedKeys.add(itemAdditionalWantedKey2);


//              "***REMOVED***",


                return Collections.singletonList(new DataToExtractFromExistingDataSourceWhenWeSearchForAGivenValue(
                                ExistingDataSourceName.ITEM,
                                "***REMOVED***",
                                itemAdditionalWantedKeys,
                                new EntryInExistingDataSource(
                                        new KeyInExistingDataSource("libelle", DataType.STRING, true,
                                                Arrays.asList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"))),
                                        new Value(
                                                "Certificat de matelot pont (2015)",
                                                DataType.STRING
                                        )
                                )
                        )
                );

            default:
                System.out.println("No matching existing source found!");
                return null;
        }
    }
}