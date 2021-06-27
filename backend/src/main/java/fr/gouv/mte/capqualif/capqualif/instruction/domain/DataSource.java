package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class DataSource {

    private JuridicalDesignations juridicalDesignation;
    private APINames APIName;
    private String APIUrl;

    public DataSource(JuridicalDesignations juridicalDesignation, APINames APIName, String APIUrl) {
        this.juridicalDesignation = juridicalDesignation;
        this.APIName = APIName;
        this.APIUrl = APIUrl;
    }

    public JuridicalDesignations getJuridicalDesignation() {
        return juridicalDesignation;
    }

    public APINames getAPIName() {
        return APIName;
    }

    public String getAPIUrl() {
        return APIUrl;
    }
}
