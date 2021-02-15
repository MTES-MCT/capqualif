package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.*;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class ConditionDataSourceToDataToSearchForInExistingDataSourceMapper {

    public DataToExtractFromExistingDataSource whatExistingDataToSearchFor(ExistingDataSourceName existingDataSourceName) {
        switch (existingDataSourceName) {
            case ADMINISTRES:

                DataToExtractFromExistingDataSource administresExistingDataInfos = new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new KeyInExistingDataSource("dateNaissance", DataType.DATE));
                return administresExistingDataInfos;

//              "***REMOVED******REMOVED***",
//

            case ESCULAPE:
                KeyInExistingDataSource esculapeAdditionalWantedKeyInExistingDataSource1 = new KeyInExistingDataSource("dateFinDeValidite", DataType.DATE);
                List<KeyInExistingDataSource> esculapeAdditionalWantedKeyInExistingDataSources = new ArrayList<>();
                esculapeAdditionalWantedKeyInExistingDataSources.add(esculapeAdditionalWantedKeyInExistingDataSource1);
                DataToExtractFromExistingDataSource esculapeExistingDataInfos = new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new KeyInExistingDataSource("libelle", DataType.STRING, true, Arrays.asList(new ParentKey(Position.POSITION_1, "decisionMedicale"))),
                        esculapeAdditionalWantedKeyInExistingDataSources);
                return esculapeExistingDataInfos;

//              "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/",

            case AMFORE:
                KeyInExistingDataSource amforeAdditionalWantedKeyInExistingDataSource1 = new KeyInExistingDataSource("dateFinValidite", DataType.DATE);
                List<KeyInExistingDataSource> amforeAdditionalWantedKeyInExistingDataSources = new ArrayList<>();
                amforeAdditionalWantedKeyInExistingDataSources.add(amforeAdditionalWantedKeyInExistingDataSource1);
                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new KeyInExistingDataSource("libelleModuleUv", DataType.STRING),
                        amforeAdditionalWantedKeyInExistingDataSources);

//              "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/",

            case ITEM:

                // ================= Additional wanted keys =================

                KeyInExistingDataSource itemAdditionalWantedKeyInExistingDataSource1 = new KeyInExistingDataSource("dateExpiration", DataType.DATE);

                KeyInExistingDataSource itemAdditionalWantedKeyInExistingDataSource2 = new KeyInExistingDataSource("libelle", DataType.STRING, true,
                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre")));

                // For testing purpose

//                Key itemAdditionalWantedKey3 = new Key("testKey", "ceQueJeVeuxKey", true,
//                        Arrays.asList(
//                                new ParentKey(Position.POSITION_1, "codeEtatTitre"),
//                                new ParentKey(Position.POSITION_2, "codeExport"),
//                                new ParentKey(Position.POSITION_3, "niveau1"),
//                                new ParentKey(Position.POSITION_4, "niveau2")));

                List<KeyInExistingDataSource> itemAdditionalWantedKeyInExistingDataSources = new ArrayList<>();
                itemAdditionalWantedKeyInExistingDataSources.add(itemAdditionalWantedKeyInExistingDataSource1);
                itemAdditionalWantedKeyInExistingDataSources.add(itemAdditionalWantedKeyInExistingDataSource2);
//                itemAdditionalWantedKeys.add(itemAdditionalWantedKey3);

                // ============================================================


//              "***REMOVED***",


                return new DataToExtractFromExistingDataSource(
                        ExistingDataSourceName.ITEM,
                        "S",
                        new KeyInExistingDataSource("libelle", DataType.STRING, true, Arrays.asList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"))),
                        itemAdditionalWantedKeyInExistingDataSources);
            default:
                System.out.println("No matching existing source found!");
                return null;
        }
    }
}