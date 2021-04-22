package fr.gouv.mte.capqualif.domain.capAdmin.mock;

import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.ConditionTitre;

public interface ExistingDataSource {
    public CorrespondingDataInExistingDataSource findByConditionValue(ConditionTitre conditionTitre);
}
