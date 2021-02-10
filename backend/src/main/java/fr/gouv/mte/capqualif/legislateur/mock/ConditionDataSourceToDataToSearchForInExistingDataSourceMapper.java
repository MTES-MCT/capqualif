package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.*;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class ConditionDataSourceToDataToSearchForInExistingDataSourceMapper {

    public DataToSearchForInExistingDataSource whatExistingDataToSearchFor(ExistingDataSourceName existingDataSourceName) {
        switch (existingDataSourceName) {
            case ADMINISTRES:

                DataToSearchForInExistingDataSource administresExistingDataInfos = new DataToSearchForInExistingDataSource(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new Key("dateNaissance", DataType.DATE));
                return administresExistingDataInfos;

//              "***REMOVED******REMOVED***",
//

            case ESCULAPE:
                Key esculapeAdditionalWantedKey1 = new Key("dateFinDeValidite", DataType.DATE);
                List<Key> esculapeAdditionalWantedKeys = new ArrayList<>();
                esculapeAdditionalWantedKeys.add(esculapeAdditionalWantedKey1);
                DataToSearchForInExistingDataSource esculapeExistingDataInfos = new DataToSearchForInExistingDataSource(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new Key("libelle", DataType.STRING, true, Arrays.asList(new ParentKey(Position.POSITION_1, "decisionMedicale"))),
                        esculapeAdditionalWantedKeys);
                return esculapeExistingDataInfos;

//              "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/",

            case AMFORE:
                Key amforeAdditionalWantedKey1 = new Key("dateFinValidite", DataType.DATE);
                List<Key> amforeAdditionalWantedKeys = new ArrayList<>();
                amforeAdditionalWantedKeys.add(amforeAdditionalWantedKey1);
                return new DataToSearchForInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new Key("libelleModuleUv", DataType.STRING),
                        amforeAdditionalWantedKeys);

//              "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/",

            case ITEM:

                // ================= Additional wanted keys =================

                Key itemAdditionalWantedKey1 = new Key("dateExpiration", DataType.DATE);

                Key itemAdditionalWantedKey2 = new Key("libelle", DataType.STRING, true,
                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre")));

                // For testing purpose

//                Key itemAdditionalWantedKey3 = new Key("testKey", "ceQueJeVeuxKey", true,
//                        Arrays.asList(
//                                new ParentKey(Position.POSITION_1, "codeEtatTitre"),
//                                new ParentKey(Position.POSITION_2, "codeExport"),
//                                new ParentKey(Position.POSITION_3, "niveau1"),
//                                new ParentKey(Position.POSITION_4, "niveau2")));

                List<Key> itemAdditionalWantedKeys = new ArrayList<>();
                itemAdditionalWantedKeys.add(itemAdditionalWantedKey1);
                itemAdditionalWantedKeys.add(itemAdditionalWantedKey2);
//                itemAdditionalWantedKeys.add(itemAdditionalWantedKey3);

                // ============================================================


//              "***REMOVED***",


                return new DataToSearchForInExistingDataSource(
                        ExistingDataSourceName.ITEM,
                        "S",
                        new Key("libelle", DataType.STRING, true, Arrays.asList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"))),
                        itemAdditionalWantedKeys);
            default:
                System.out.println("No matching existing source found!");
                return null;
        }
    }
}