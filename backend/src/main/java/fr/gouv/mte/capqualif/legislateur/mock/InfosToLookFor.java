package fr.gouv.mte.capqualif.legislateur.mock;

import org.springframework.stereotype.Component;

import java.util.*;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class InfosToLookFor {

    public Map<String, List> whatInfosToLookFor(String existingDataSource) {
        HashMap<String, List> infos = new HashMap<>();
        switch(existingDataSource) {
            case("administres"):
                infos.put("source", Collections.singletonList("***REMOVED******REMOVED***"));
                infos.put("mainWantedKey", Collections.singletonList("dateNaissance"));
                return infos;
            case("esculape"):
                infos.put("source", Collections.singletonList("http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/"));
                infos.put("mainWantedKey", Collections.singletonList("libelle"));
                List<Map<String, String>> esculapeAdditionalWantedKeys = new ArrayList<>();
                esculapeAdditionalWantedKeys.add(createMap("expirationKey", "dateFinDeValidite"));
                infos.put("additionalWantedKeys", esculapeAdditionalWantedKeys);
                return infos;
            case("amfore"):
                infos.put("source", Collections.singletonList("http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/"));
                infos.put("mainWantedKey", Collections.singletonList("libelleModuleUv"));
                List<Map<String, String>> amforeAdditionalWantedKeys = new ArrayList<>();
                amforeAdditionalWantedKeys.add(createMap("expirationKey", "dateFinValidite"));
                infos.put("additionalWantedKeys", amforeAdditionalWantedKeys);
                return infos;
            case("item"):
                infos.put("source", Collections.singletonList("***REMOVED***"));
                infos.put("mainWantedKey", Collections.singletonList("libelle"));
                List<Map<String, String>> itemAdditionalWantedKeys = new ArrayList<>();
                itemAdditionalWantedKeys.add(createMap("expirationKey", "dateExpiration"));
                itemAdditionalWantedKeys.add(createMap("validityKey", "libelle"));
                infos.put("additionalWantedKeys", itemAdditionalWantedKeys);
                return infos;
            default:
                System.out.println("No matching existing source found!");
        }
        return null;
    }

    private Map<String, String> createMap(String keyName, String keyValue) {
        Map<String, String> map = new HashMap<>();
        map.put(keyName, keyValue);
        return map;
    };
}