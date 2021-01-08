package fr.gouv.mte.capqualif.instructeur.application.ports.out;

import fr.gouv.mte.capqualif.instructeur.domain.Entry;
import fr.gouv.mte.capqualif.legislateur.mock.DataToSearchForInExistingDataSource;
import fr.gouv.mte.capqualif.titre.domain.Value;

import java.util.List;

public interface GetMarinDataPort {
    List<Entry> getMarinData(String numeroDeMarin, Value mainValue, DataToSearchForInExistingDataSource dataToSearchForInExistingDataSource);
}
