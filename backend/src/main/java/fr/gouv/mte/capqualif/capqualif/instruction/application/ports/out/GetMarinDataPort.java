package fr.gouv.mte.capqualif.capqualif.instruction.application.ports.out;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.MarinData;

import java.util.Map;

public interface GetMarinDataPort {

    Map<String, MarinData> getAllMarinData(String marinId);

}
