package fr.gouv.mte.capqualif.instructeur.adapters.out.api.mock;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.instructeur.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.utils.LocalJsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataMapper {

    // NOTE : in the future, this infos will be built in the DAM module
    public Map whatInfosToLookFor(String existingDataSource) {
        HashMap<String, String> infos = new HashMap<>();
        switch(existingDataSource) {
            case("dumbSource"):
                infos.put("source", "https://jsonplaceholder.typicode.com/posts");
                infos.put("simpleField", "title");
                return infos;
            case("administres"):
                // Marin de moins de 16 ans
//                infos.put("source", "https://run.mocky.io/v3/b33b5c2f-0c95-46c1-ac8d-a33b918f0bac");

                // Marin de plus de 16 ans
//                infos.put("source", "https://run.mocky.io/v3/d05d9429-48e4-4785-a8a4-b353de3d94da");

                // Vraie source
                infos.put("source", "***REMOVED******REMOVED***");
                infos.put("simpleField", "dateNaissance");
                return infos;
            case("esculape"):
                // Marin apte
//                infos.put("source", "https://run.mocky.io/v3/1957dab6-73e3-49db-aece-d21599093db5");

                // Marin apte mais périmé
//                infos.put("source", "https://run.mocky.io/v3/86517f52-2fe6-4bb3-a786-14561dae7f68");

                // Vraie source
                infos.put("source", "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/");
                infos.put("simpleField", "decisionMedicale");
                infos.put("nestedField", "libelle");
                infos.put("expirationField", "dateFinDeValidite");
                return infos;
            case("amfore"):
                // Vraie source
                infos.put("source", "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/");
                infos.put("simpleField", "decisionMedicale");
                infos.put("nestedField", "libelle");
                infos.put("expirationField", "dateFinDeValidite");
        }
        return null;
    }
}
