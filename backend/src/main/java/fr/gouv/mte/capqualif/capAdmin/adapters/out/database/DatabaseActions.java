package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreJpaEntity;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreRepository;
import fr.gouv.mte.capqualif.capAdmin.application.services.EvaluationService;
import fr.gouv.mte.capqualif.capAdmin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
//@Transactional
public class DatabaseActions {

    @Autowired
    TitreRepository titreRepository;

    @Autowired
    EvaluationService evaluationService;

    public void save(Titre titre) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(titre.getConditions());
        System.out.println("------------------------ " + json);
        this.titreRepository.save(new TitreJpaEntity(titre.getName(), json));
    }

    public void find(Long id) {
        TitreJpaEntity titreJpa = this.titreRepository.findById(id).get();
        System.out.println("!!!! titre found " + titreJpa);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        // https://stackoverflow.com/a/5554296
        Type listType = new TypeToken<ArrayList<Condition>>(){}.getType();
        List<Condition> list = new Gson().fromJson(titreJpa.getConditions(), listType);

        Titre titre = new Titre(titreJpa.getName(), list);
        System.out.println(titre);

        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "21"),
                new Data<String>("aptitude", "apte"),
                new Data<List<String>>("formations", Arrays.asList("Module P1-Appui navigation"
                        , "Module P2-Appui manutention et arrimage de la cargaison, pêche")),
                new Data<List<String>>("titres", Arrays.asList("CFBS"))
        )
        );

        ParseResult result = evaluationService.processTitre(titre, marin);
        System.out.println(result);
    }
}
