
package fr.gouv.mte.capqualif.marin.adapters.out.api.dto;


import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.CodeFrmTitreCapaciteRestriction;
import fr.gouv.mte.capqualif.marin.adapters.out.api.dto.CodeFrmTitreCapaciteStwc;

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
