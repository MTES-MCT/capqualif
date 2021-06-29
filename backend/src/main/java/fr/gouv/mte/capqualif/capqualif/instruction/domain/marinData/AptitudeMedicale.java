package fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData.MarinData;

public class AptitudeMedicale extends MarinData {

    public AptitudeMedicale(String value, String endOfValidity) {
        this.value = value;
        this.endOfValidity = endOfValidity;
    }

    @Override
    public String toString() {
        return "AptitudeMedicale{" +
                "value='" + value + '\'' +
                ", endOfValidity='" + endOfValidity + '\'' +
                '}';
    }
}
