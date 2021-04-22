package fr.gouv.mte.capqualif.capAdmin.adapters.out.mock;

import fr.gouv.mte.capqualif.capAdmin.titre.domain.ConditionTitre;

public interface ExistingDataSource {
    public CorrespondingDataInExistingDataSource findByConditionValue(ConditionTitre conditionTitre);
}
