package fr.gouv.mte.capqualif.capadmin.adapters.out.persistence.temp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fr.gouv.mte.capqualif.capadmin.adapters.out.persistence.TitreJpaEntity;
import fr.gouv.mte.capqualif.capadmin.adapters.out.persistence.TitreRepository;
import fr.gouv.mte.capqualif.capadmin.application.services.temp.EvaluationService;
import fr.gouv.mte.capqualif.capadmin.domain.*;
import fr.gouv.mte.capqualif.capadmin.domain.temp.Marin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseActions {

    @Autowired
    TitreRepository titreRepository;

    @Autowired
    EvaluationService evaluationService;

    public void find(Long id) {
        Optional<TitreJpaEntity> titreJpaOpt = this.titreRepository.findById(id);
        if (titreJpaOpt.isPresent()) {
            TitreJpaEntity titreJpa = titreJpaOpt.get();
//            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            // https://stackoverflow.com/a/5554296
            Type listType = new TypeToken<ArrayList<Condition>>(){}.getType();
            List<Condition> list = new Gson().fromJson(titreJpa.getConditions(), listType);
            Titre titre = new Titre(titreJpa.getName(), list);

            Marin marin = new Marin(Arrays.asList(
                    new Data<String>("age", "21"),
                    new Data<String>("aptitude", "apte"),
                    new Data<List<String>>("formations", Arrays.asList("Module P1-Appui navigation"
                            , "Module P2-Appui manutention et arrimage de la cargaison, pêche")),
                    new Data<List<String>>("titres", Arrays.asList("CFBS"))
            )
            );

            ParseResult result = evaluationService.processTitre(titre, marin);
        }
    }
}
