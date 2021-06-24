
package fr.gouv.mte.capqualif.capqualif.request.adapters.out.api.dto;


public class TitreCapaciteRest {

    private String restrictionLibre;
    private String restrictionLibreAnglais;
    private CodeFrmTitreCapaciteRestriction codeFrmTitreCapaciteRestriction;
    private CodeFrmTitreCapaciteStwc codeFrmTitreCapaciteStwc;

    public String getRestrictionLibre() {
        return restrictionLibre;
    }

    public String getRestrictionLibreAnglais() {
        return restrictionLibreAnglais;
    }

    public CodeFrmTitreCapaciteRestriction getCodeFrmTitreCapaciteRestrictionDTO() {
        return codeFrmTitreCapaciteRestriction;
    }

    public CodeFrmTitreCapaciteStwc getCodeFrmTitreCapaciteStwcDTO() {
        return codeFrmTitreCapaciteStwc;
    }
}
