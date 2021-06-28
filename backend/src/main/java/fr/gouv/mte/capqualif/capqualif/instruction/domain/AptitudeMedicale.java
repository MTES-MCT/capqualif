package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class AptitudeMedicale extends MarinData {

    private final String value;
    private final String endOfValidity;

    public AptitudeMedicale(String value, String endOfValidity) {
        this.value = value;
        this.endOfValidity = endOfValidity;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getEndOfValidity() {
        return endOfValidity;
    }

    @Override
    public String toString() {
        return "AptitudeMedicale{" +
                "value='" + value + '\'' +
                ", endOfValidity='" + endOfValidity + '\'' +
                '}';
    }
}
