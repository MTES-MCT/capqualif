package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData.MarinData;

import java.util.List;
import java.util.Map;

public interface GetMarinDataPort {

    Map<String, List<MarinData>> getAllMarinData(String marinId);

}
