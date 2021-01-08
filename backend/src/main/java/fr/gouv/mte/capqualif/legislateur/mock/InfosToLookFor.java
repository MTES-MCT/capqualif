package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.springframework.stereotype.Component;

import java.util.*;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class InfosToLookFor {

    public ExistingAPIMapper whatExistingDataInfosToLookFor(ExistingDataSourceName existingDataSourceName) {
        switch (existingDataSourceName) {
            case ADMINISTRES:

                ExistingAPIMapper administresExistingDataInfos = new ExistingAPIMapper(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new Key("mainKey", "dateNaissance"));
                return administresExistingDataInfos;

//              "***REMOVED******REMOVED***",
//

            case ESCULAPE:
                Key esculapeAdditionalWantedKey1 = new Key("expirationKey", "dateFinDeValidite");
                List<Key> esculapeAdditionalWantedKeys = new ArrayList<>();
                esculapeAdditionalWantedKeys.add(esculapeAdditionalWantedKey1);
                ExistingAPIMapper esculapeExistingDataInfos = new ExistingAPIMapper(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new Key("mainKey", "libelle", true, Arrays.asList(new ParentKey(Position.POSITION_1, "decisionMedicale"))),
                        esculapeAdditionalWantedKeys);
                return esculapeExistingDataInfos;

//              "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/",

            case AMFORE:
                Key amforeAdditionalWantedKey1 = new Key("expirationKey", "dateFinValidite");
                List<Key> amforeAdditionalWantedKeys = new ArrayList<>();
                amforeAdditionalWantedKeys.add(amforeAdditionalWantedKey1);
                return new ExistingAPIMapper(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new Key("mainKey", "libelleModuleUv"),
                        amforeAdditionalWantedKeys);

//              "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/",

            case ITEM:

                // ================= Additional wanted keys =================

                Key itemAdditionalWantedKey1 = new Key("expirationKey", "dateExpiration");

                Key itemAdditionalWantedKey2 = new Key("validityKey", "libelle", true,
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


                return new ExistingAPIMapper(
                        ExistingDataSourceName.ITEM,
                        "***REMOVED***",
                        new Key("mainKey", "libelle", true, Arrays.asList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"))),
                        itemAdditionalWantedKeys);
            default:
                System.out.println("No matching existing source found!");
                return null;
        }
    }
}