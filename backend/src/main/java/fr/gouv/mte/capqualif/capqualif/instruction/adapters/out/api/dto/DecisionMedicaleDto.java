package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class DecisionMedicaleDto {

    private String code;

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "DecisionMedicaleDTO{" +
                "code='" + code + '\'' +
                '}';
    }
}