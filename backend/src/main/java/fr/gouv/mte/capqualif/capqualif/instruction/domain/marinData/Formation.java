package fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData.MarinData;

public class Formation extends MarinData {

    public Formation(String value, String endOfValidity) {
        this.value = value;
        this.endOfValidity = endOfValidity;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "value='" + value + '\'' +
                ", endOfValidity='" + endOfValidity + '\'' +
                '}';
    }
}
