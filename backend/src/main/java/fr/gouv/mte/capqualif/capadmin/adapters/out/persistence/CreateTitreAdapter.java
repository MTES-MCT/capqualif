package fr.gouv.mte.capqualif.capadmin.adapters.out.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.gouv.mte.capqualif.capadmin.application.ports.out.CreateTitrePort;
import fr.gouv.mte.capqualif.capadmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTitreAdapter implements CreateTitrePort {

    @Autowired
    TitreRepository titreRepository;

    @Autowired
    Mapper mapper;

    @Override
    public Titre createTitre(Titre titre) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(titre.getConditions());
        return mapper.toDomainEntity(this.titreRepository.save(new TitreJpaEntity(titre.getName(), json)));
    }

}
