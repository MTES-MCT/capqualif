package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import fr.gouv.mte.capqualif.legislateur.mock.DataInExistingJsonAPI;

import java.util.List;
import java.util.Map;

public interface GetMarinDataPort {
    List<Map<String, String>> getMarinData(String numeroDeMarin, String conditionValue, DataInExistingJsonAPI dataInExistingJsonAPI);
}
