package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import com.google.gson.JsonElement;
import fr.gouv.mte.capqualif.legislateur.mock.ExistingDataInfos;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;

import java.util.List;
import java.util.Map;

public interface GetMarinDataPort {
    JsonElement getMarinData(String numeroDeMarin, ConditionTitre conditionTitre, ExistingDataInfos existingDataInfos);
}
