package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class AmforeDTO implements APIDataDTO {

    private String libelleVersionFormation;
    private String dateAcquisition;
    private String libelleModuleUv;

    @Override
    public String toString() {
        return "AmforeDTO{" +
                "libelleVersionFormation='" + libelleVersionFormation + '\'' +
                ", dateAcquisition='" + dateAcquisition + '\'' +
                ", libelleModuleUv='" + libelleModuleUv + '\'' +
                '}';
    }
}
