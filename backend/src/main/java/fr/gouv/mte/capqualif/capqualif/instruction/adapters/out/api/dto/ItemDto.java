package fr.gouv.mte.capqualif.capqualif.instruction.adapters.out.api.dto;

public class ItemDto extends ApiDataDto {

    private String dateExpiration;
    private CodeEtatTitreDto codeEtatTitre;
    private CodeBrevetMarinDto codeBrevetMarin;

    public String getDateExpiration() {
        return dateExpiration;
    }

    public CodeEtatTitreDto getCodeEtatTitre() {
        return codeEtatTitre;
    }

    public CodeBrevetMarinDto getCodeBrevetMarin() {
        return codeBrevetMarin;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "dateExpiration='" + dateExpiration + '\'' +
                ", codeEtatTitre=" + codeEtatTitre +
                ", codeBrevetMarin=" + codeBrevetMarin +
                '}';
    }
}

//class TitreState {
//    private String code;
//    private String libelle;
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getLibelle() {
//        return libelle;
//    }
//
//    @Override
//    public String toString() {
//        return "TitreState{" +
//                "code='" + code + '\'' +
//                ", libelle='" + libelle + '\'' +
//                '}';
//    }
//}
