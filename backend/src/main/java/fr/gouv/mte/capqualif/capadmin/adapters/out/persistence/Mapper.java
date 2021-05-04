package fr.gouv.mte.capqualif.capadmin.adapters.out.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capadmin.domain.Condition;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public Titre toDomainEntity(TitreJpaEntity titreJpaEntity) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        // https://stackoverflow.com/a/5554296
        Type listType = new TypeToken<ArrayList<Condition>>(){}.getType();
        List<Condition> list = new Gson().fromJson(titreJpaEntity.getConditions(), listType);
        return new Titre(titreJpaEntity.getName(), list);
    }

}
