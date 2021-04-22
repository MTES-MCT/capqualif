package fr.gouv.mte.capqualif.capAdmin.adapters.out.mock;

import fr.gouv.mte.capqualif.capAdmin.titre.domain.ConditionTitre;
import org.springframework.stereotype.Component;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class ConditionTitreToRealDataInExistingDataSourcesMapper {

    private ExistingDataSource existingDataSource;

    public ConditionTitreToRealDataInExistingDataSourcesMapper(ExistingDataSource existingDataSource) {
        this.existingDataSource = existingDataSource;
    }

    public CorrespondingDataInExistingDataSource getInfosForSearchInExistingSource(ConditionTitre conditionTitre) {
        CorrespondingDataInExistingDataSource correspondingDataInExistingDataSource = existingDataSource.findByConditionValue(conditionTitre);
        return correspondingDataInExistingDataSource;
    }
}