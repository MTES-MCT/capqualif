package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class Formation extends MarinData {

    private final String value;
    private final String endOfValidity;

    public Formation(String value, String endOfValidity) {
        this.value = value;
        this.endOfValidity = endOfValidity;
    }

    public String getValue() {
        return value;
    }

    public String getEndOfValidity() {
        return endOfValidity;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "value='" + value + '\'' +
                ", endOfValidity='" + endOfValidity + '\'' +
                '}';
    }
}
