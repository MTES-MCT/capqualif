package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;

public interface ExistingDataSource {
    public DataToExtractFromExistingDataSource findByConditionValue(ConditionTitre conditionTitre);
}
