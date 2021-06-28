package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class AmforeDto extends ApiDataDto {

    private String dateAcquisition;
    private String libelleModuleUv;

    public String getDateAcquisition() {
        return dateAcquisition;
    }

    public String getLibelleModuleUv() {
        return libelleModuleUv;
    }

    @Override
    public String toString() {
        return "AmforeDto{" +
                "dateAcquisition='" + dateAcquisition + '\'' +
                ", libelleModuleUv='" + libelleModuleUv + '\'' +
                '}';
    }
}
