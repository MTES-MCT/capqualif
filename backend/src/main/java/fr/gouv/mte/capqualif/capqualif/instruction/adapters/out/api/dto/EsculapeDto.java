package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class EsculapeDto extends ApiDataDto {

    private final DecisionMedicaleDto decisionMedicale;
    private final String dateFinDeValidite;

    public EsculapeDto(DecisionMedicaleDto decisionMedicale, String dateFinDeValidite) {
        this.decisionMedicale = decisionMedicale;
        this.dateFinDeValidite = dateFinDeValidite;
    }

    public DecisionMedicaleDto getDecisionMedicale() {
        return decisionMedicale;
    }

    public String getDateFinDeValidite() {
        return dateFinDeValidite;
    }

    @Override
    public String toString() {
        return "EsculapeDTO{" +
                "decisionMedicale=" + decisionMedicale +
                ", dateFinDeValidite='" + dateFinDeValidite + '\'' +
                '}';
    }
}

