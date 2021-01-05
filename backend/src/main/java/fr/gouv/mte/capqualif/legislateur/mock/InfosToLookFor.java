package fr.gouv.mte.capqualif.legislateur.mock;

import org.springframework.stereotype.Component;

import java.util.*;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class InfosToLookFor {

    public ExistingDataInfos whatExistingDataInfosToLookFor(String existingDataSource) {
        switch (existingDataSource) {
            case ("administres"):
                ExistingDataInfos administresExistingDataInfos = new ExistingDataInfos(
                        "administres",
                        "***REMOVED******REMOVED***",
                        "dateNaissance");
                return administresExistingDataInfos;
            case ("esculape"):
                Key esculapeAdditionalWantedKey1 = new Key("expirationKey", "dateFinDeValidite");
                List<Key> esculapeAdditionalWantedKeys = new ArrayList<>();
                esculapeAdditionalWantedKeys.add(esculapeAdditionalWantedKey1);
                ExistingDataInfos esculapeExistingDataInfos = new ExistingDataInfos(
                        "esculape",
                        "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/",
                        "libelle",
                        esculapeAdditionalWantedKeys
                );
                return esculapeExistingDataInfos;
            case ("amfore"):
                Key amforeAdditionalWantedKey1 = new Key("expirationKey", "dateFinValidite");
                List<Key> amforeAdditionalWantedKeys = new ArrayList<>();
                amforeAdditionalWantedKeys.add(amforeAdditionalWantedKey1);
                ExistingDataInfos amforeExistingDataInfos = new ExistingDataInfos(
                        "amfore",
                        "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/",
                        "libelleModuleUv",
                        amforeAdditionalWantedKeys
                );
                return amforeExistingDataInfos;
            case ("item"):

                // ================= Additional wanted keys =================

                Key itemAdditionalWantedKey1 = new Key("expirationKey", "dateExpiration");

                Key itemAdditionalWantedKey2 = new Key("validityKey", "libelle", true,
                        Arrays.asList(new ParentKey(Position.POSITION_1, "codeEtatTitre")));

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

                ExistingDataInfos itemExistingDataInfos = new ExistingDataInfos(
                        "item",
                        "***REMOVED***",
                        "libelle",
                        itemAdditionalWantedKeys);

                // With the real url :
//                ExistingDataInfos itemExistingDataInfos = new ExistingDataInfos(
//                        "item",
//                        "***REMOVED***",
//                        "libelle",
//                        itemAdditionalWantedKeys);
                return itemExistingDataInfos;
            default:
                System.out.println("No matching existing source found!");
                return null;
        }
    }
}

//    public Map<String, List> whatInfosToLookFor(String existingDataSource) {
//        HashMap<String, List> infos = new HashMap<>();
//        switch(existingDataSource) {
//            case("administres"):
//                infos.put("source", Collections.singletonList("***REMOVED***
//                ***REMOVED***"));
//                infos.put("mainWantedKey", Collections.singletonList("dateNaissance"));
//                return infos;
//            case("esculape"):
//                infos.put("source", Collections.singletonList("http://ws-esculape-capqualif-test.dsi.damgm
//                .i2/esculape/api/v1/aptitudes/"));
//                infos.put("mainWantedKey", Collections.singletonList("libelle"));
//                List<Map<String, String>> esculapeAdditionalWantedKeys = new ArrayList<>();
//                esculapeAdditionalWantedKeys.add(createMap("expirationKey", "dateFinDeValidite"));
//                infos.put("additionalWantedKeys", esculapeAdditionalWantedKeys);
//                return infos;
//            case("amfore"):
//                infos.put("source", Collections.singletonList("http://ws-amfore-capqualif-test.dsi.damgm
//                .i2/amfore/api/v1/acquisitions/"));
//                infos.put("mainWantedKey", Collections.singletonList("libelleModuleUv"));
//                List<Map<String, String>> amforeAdditionalWantedKeys = new ArrayList<>();
//                amforeAdditionalWantedKeys.add(createMap("expirationKey", "dateFinValidite"));
//                infos.put("additionalWantedKeys", amforeAdditionalWantedKeys);
//                return infos;
//            case("item"):
//                infos.put("source", Collections.singletonList("http://ws-item-back-capqualif-test.dsi.damgm
//                .i2/item-back/api/v1/titres/"));
//                infos.put("mainWantedKey", Collections.singletonList("libelle"));
//                List<Map<String, String>> itemAdditionalWantedKeys = new ArrayList<>();
//                itemAdditionalWantedKeys.add(createMap("expirationKey", "dateExpiration"));
//                itemAdditionalWantedKeys.add(createMap("validityKey", "libelle"));
//                infos.put("additionalWantedKeys", itemAdditionalWantedKeys);
//                return infos;
//            default:
//                System.out.println("No matching existing source found!");
//        }
//        return null;
//    }
//
//    private Map<String, String> createMap(String keyName, String keyValue) {
//        Map<String, String> map = new HashMap<>();
//        map.put(keyName, keyValue);
//        return map;
//    };
