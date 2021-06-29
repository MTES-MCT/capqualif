package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class Titre extends MarinData {

    private final String value;
    private final String endOfValidity;
    private final String status;

    public Titre(String value, String endOfValidity, String status) {
        this.value = value;
        this.endOfValidity = endOfValidity;
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public String getEndOfValidity() {
        return endOfValidity;
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
