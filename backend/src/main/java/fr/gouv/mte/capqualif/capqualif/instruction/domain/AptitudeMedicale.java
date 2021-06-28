package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class AptitudeMedicale extends MarinData {

    private String endOfValidity;
    private String value;

    public AptitudeMedicale(String endOfValidity, String value) {
        this.endOfValidity = endOfValidity;
        this.value = value;
    }

    public String getEndOfValidity() {
        return endOfValidity;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AptitudeMedicale{" +
                "dateFinDeValidite='" + endOfValidity + '\'' +
                ", codeDecisionMedicale='" + value + '\'' +
                '}';
    }
}
