package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import fr.gouv.mte.capqualif.legislateur.mock.DataInExistingJsonAPI;
import fr.gouv.mte.capqualif.titre.domain.Value;

import java.util.List;
import java.util.Map;

public interface GetMarinDataPort {
    List<Map<String, String>> getMarinData(String numeroDeMarin, Value mainValue, DataInExistingJsonAPI dataInExistingJsonAPI);
}
