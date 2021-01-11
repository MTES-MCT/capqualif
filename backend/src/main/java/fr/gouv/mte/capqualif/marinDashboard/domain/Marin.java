
package fr.gouv.mte.capqualif.marinDashboard.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Marin {

    public String numIdentification;
    public String nom;
    public String nomUsage;
    public String prenom;
    public String numeroLpm;
    public String numeroFixe;
    public String numeroPortable;
    public String adresseMessagerie;
    public String dateNaissance;
    public String dateIdentification;
    public String dateStatutDelivrance;
    public CodeStatutAdm codeStatutAdm;
    public CodeStatutLpm codeStatutLpm;
    public CodeNationalite codeNationalite;
    public CodeCivilite codeCivilite;
    public CodeServiceRattachement codeServiceRattachement;
    public CodeRegimeSociale codeRegimeSociale;
    public List<ListQualification> listQualifications = null;
    public Boolean estMarin;
    public String villeNaissance;
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}


//package fr.gouv.mte.capqualif.marinDashboard.domain;
//
//public class Marin {
//
//    // [Numéro de marin] The official number
//    private String numeroDeMarin;                                  // numeroIdentification dans Objet IndividuDto (numIdentification dans doc API ADM)
//
//    // Civil data : birth date, address, phone number, email...
//    private MarinCivilData marinCivilData;
//
//    // Identity markers : photo, signature...
//    private MarinIdentityMarkersData marinIdentityMarkersData;
//
//    // Education : titles, visas...
//    private MarinEducationData marinEducationData;
//
//    public Marin(String numeroDeMarin, MarinCivilData marinCivilData, MarinIdentityMarkersData marinIdentityMarkersData, MarinEducationData marinEducationData) {
//        this.numeroDeMarin = numeroDeMarin;
//        this.marinCivilData = marinCivilData;
//        this.marinIdentityMarkersData = marinIdentityMarkersData;
//        this.marinEducationData = marinEducationData;
//    }
//
//    public String getNumeroDeMarin() {
//        return numeroDeMarin;
//    }
//
//    public MarinCivilData getMarinCivilData() {
//        return marinCivilData;
//    }
//
//    public MarinIdentityMarkersData getMarinIdentityMarkersData() {
//        return marinIdentityMarkersData;
//    }
//
//    public MarinEducationData getMarinEducationData() {
//        return marinEducationData;
//    }
//}
