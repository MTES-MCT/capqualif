package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class EsculapeDTO implements APIDataDTO {
    private DecisionMedicaleDTO decisionMedicale;
    private String dateFinDeValidite;

    public DecisionMedicaleDTO getDecisionMedicale() {
        return decisionMedicale;
    }
    public String getDateFinDeValidite() {
        return dateFinDeValidite;
    }

    @Override
    public String toString() {
        return "EsculapeDTO{" +
                "dateFinDeValidite='" + dateFinDeValidite + '\'' +
                ", decisionMedicale=" + decisionMedicale +
                '}';
    }
}

