package fr.gouv.mte.capqualif.capAdmin.adapters.out.database;

import fr.gouv.mte.capqualif.capAdmin.domain.Titre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TitreMapper {

    @Autowired
    ConditionMapper conditionMapper;

//    public TitreJpaEntity mapToJpaEntity(Titre titre) {
//        return new TitreJpaEntity(
//                titre.getName(),
//                conditionMapper.mapToJpaEntity(titre.getConditions().get(0))
//        );

//    }

}
