package fr.gouv.mte.capqualif.capAdmin.application.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreJpaEntity;
import fr.gouv.mte.capqualif.capAdmin.adapters.out.database.TitreRepository;
import fr.gouv.mte.capqualif.capAdmin.domain.Condition;
import fr.gouv.mte.capqualif.capAdmin.domain.ParseResult;
import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
//@Transactional
public class Test {

    @Autowired
    TitreRepository titreRepository;

    @Autowired
    EvaluationService evaluationService;

//    @PersistenceContext
//    private EntityManager entityManager;

    public void save(Titre titre) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(titre.getConditions());
        System.out.println("------------------------ " + json);
//        save(new TitreJpaEntity("blabl", json));
        this.titreRepository.save(new TitreJpaEntity(titre.getName(), json));
    }

    public void find(Long id) {
        TitreJpaEntity titreJpa = this.titreRepository.findById(id).get();
        System.out.println("!!!! titre found " + titreJpa);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Type listType = new TypeToken<ArrayList<Condition>>(){}.getType();
        List<Condition> list = new Gson().fromJson(titreJpa.getConditions(), listType);
        Titre titre = new Titre(titreJpa.getName(), list);
        System.out.println(titre);
        ParseResult result = evaluationService.processTitre(titre, null);
        System.out.println(result);
    }

//    @Transactional
//    public TitreJpaEntity save(TitreJpaEntity titreJpaEntity) {
//        entityManager.persist(
//                titreJpaEntity
//        );
//        return titreJpaEntity;
//    };

}
