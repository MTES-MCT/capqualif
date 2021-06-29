package fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData;

public class MarinDataPurified {

    private String value;

    public MarinDataPurified(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MarinDataPurified{" +
                "value='" + value + '\'' +
                '}';
    }
}
