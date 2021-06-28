package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

import fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.APINames;

public class EsculapeDTO extends APIDataDTO {

    private final DecisionMedicaleDTO decisionMedicale;
    private final String dateFinDeValidite;

    public EsculapeDTO(DecisionMedicaleDTO decisionMedicale, String dateFinDeValidite) {
        this.decisionMedicale = decisionMedicale;
        this.dateFinDeValidite = dateFinDeValidite;
    }

    public DecisionMedicaleDTO getDecisionMedicale() {
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

