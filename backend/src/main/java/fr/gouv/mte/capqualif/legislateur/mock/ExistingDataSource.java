package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;

public interface ExistingDataSource {
    public CorrespondingDataInExistingDataSource findByConditionValue(ConditionTitre conditionTitre);
}