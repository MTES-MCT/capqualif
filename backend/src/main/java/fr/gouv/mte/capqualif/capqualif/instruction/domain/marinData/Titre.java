package fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData;

import fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData.MarinData;

public class Titre extends MarinData {

    private final String status;

    public Titre(String value, String endOfValidity, String status) {
        super(value, endOfValidity);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Titre{" +
                "value='" + value + '\'' +
                ", endOfValidity='" + endOfValidity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
