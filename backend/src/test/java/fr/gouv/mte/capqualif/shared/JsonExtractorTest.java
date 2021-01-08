package fr.gouv.mte.capqualif.shared;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fr.gouv.mte.capqualif.legislateur.mock.Key;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ValueType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonExtractorTest {

    LocalJsonGetter localJsonGetter;
    JsonElement initialJson;

    @Before
    public void setUp() throws Exception {
        localJsonGetter = new LocalJsonGetter();
    }

    @Test
    public void findItemFirstLevelMatchingJson() {
        initialJson = localJsonGetter.getJson("mocks/titresDetenus.json");
        String expected = getExpectedResult("item", "1");
        JsonExtractor jsonExtractor = new JsonExtractor();
        Key mainWantedKey = new Key("mainWantedKey", "idIteTitreDetenu");
        JsonObject tested = jsonExtractor.findJsonObjectByEntryValue(initialJson, mainWantedKey, new Value("839308", ValueType.STRING));
        assertEquals(expected.replaceAll("\\s", ""), tested.toString().replaceAll("\\s", ""));
    }

    @Test
    public void findItemSecondLevelMatchingJson() {
        initialJson = localJsonGetter.getJson("mocks/titresDetenus.json");
        String expected = getExpectedResult("item", "2");
        JsonExtractor jsonExtractor = new JsonExtractor();
        Key mainWantedKey = new Key("mainWantedKey", "libelle");
        JsonObject tested = jsonExtractor.findJsonObjectByEntryValue(initialJson, mainWantedKey,  new Value("Certificat de matelot pont (2015)", ValueType.STRING)
                );
        assertEquals(expected.replaceAll("\\s", ""), tested.toString().replaceAll("\\s", ""));
    }

    @Test
    public void findAmforeFirstLevelMatchingJson() {
        initialJson = localJsonGetter.getJson("mocks/acquisitions.json");
        String expected = getExpectedResult("amfore", "1");
        JsonExtractor jsonExtractor = new JsonExtractor();
        Key mainWantedKey = new Key("mainWantedKey", "libelleModuleUv");
        JsonObject tested = jsonExtractor.findJsonObjectByEntryValue(initialJson, mainWantedKey, new Value("P3–Appui-Exploitation/assist/entretien/répar", ValueType.STRING));
        assertEquals(expected.replaceAll("\\s", ""), tested.toString().replaceAll("\\s", ""));
    }

    @Test
    public void findEsculapeFirstLevelMatchingJson() {
        initialJson = localJsonGetter.getJson("mocks/aptitudeMedicale.json");
        String expected = getExpectedResult("esculape", "1");
        JsonExtractor jsonExtractor = new JsonExtractor();
        Key mainWantedKey = new Key("mainWantedKey", "rendezVous");
        JsonObject tested = jsonExtractor.findJsonObjectByEntryValue(initialJson, mainWantedKey, new Value("1608073200000", ValueType.STRING));
        assertEquals(expected.replaceAll("\\s", ""), tested.toString().replaceAll("\\s", ""));
    }

    @Test
    public void findEsculapeSecondLevelMatchingJson() {
        initialJson = localJsonGetter.getJson("mocks/aptitudeMedicale.json");
        String expected = getExpectedResult("esculape", "2");
        JsonExtractor jsonExtractor = new JsonExtractor();
        Key mainWantedKey = new Key("mainWantedKey", "libelle");
        JsonObject tested = jsonExtractor.findJsonObjectByEntryValue(initialJson, mainWantedKey, new Value("Apte TF/TN", ValueType.STRING));
        assertEquals(expected.replaceAll("\\s", ""), tested.toString().replaceAll("\\s", ""));
    }


    private String getExpectedResult(String API, String level) {
        switch (API) {
            case "item":
                if (level.equals("1")) {
                    return "{\n" + "    \"idIteTitreDetenu\": 839308,\n" + "    \"idIteVisaAttestaion\": null,\n" + "    \"numeroTitre\": \"123\",\n" + "    \"numeroVisa\": null,\n" + "    \"dateDelivrance\": " + "\"09/04/2020\",\n" + "    \"dateRevalidation\": null,\n" + "    \"dateEffet\": \"12/02/2020\",\n" + "    \"dateExpiration\": \"11/02/2025\",\n" + "    \"codeEtatTitre\": {\n" + "      \"idc\": 3,\n" + "      \"code\": \"03\",\n" + "      \"libelle\": \"Valide\",\n" + "      \"libelleAnglais\": " + "\"Valid\",\n" + "      \"libelleCourt\": null,\n" + "      \"dateDebutApplication\": null,\n" + "   " + "   \"dateFinApplication\": null,\n" + "      \"bloque\": false,\n" + "      \"codeExport\": " + "null\n" + "    },\n" + "    \"codeEtatVisa\": null,\n" + "    \"codeBrevetMarin\": {\n" + "      " + "\"idc\": 243,\n" + "      \"code\": \"9556\",\n" + "      \"libelle\": \"Certificat de formation de " + "base à la sécurité (STCW10)\",\n" + "      \"libelleAnglais\": null,\n" + "      \"libelleCourt\": " + "null,\n" + "      \"dateDebutApplication\": \"2013-07-26\",\n" + "      \"dateFinApplication\": " + "null,\n" + "      \"bloque\": false,\n" + "      \"codeExport\": null,\n" + "      " + "\"codeFrmFamilleTitre\": {\n" + "        \"idc\": 3,\n" + "        \"code\": \"CERTIFICAT\",\n" + " " + "       \"libelle\": \"Certificat\",\n" + "        \"libelleAnglais\": null,\n" + "        " + "\"libelleCourt\": null,\n" + "        \"dateDebutApplication\": null,\n" + "        " + "\"dateFinApplication\": null,\n" + "        \"bloque\": false,\n" + "        \"codeExport\": null\n" + "      },\n" + "      \"infoBrevetPourPmrLong\": null\n" + "    },\n" + "    \"codeAutoriteDelivrance\": {\n" + "      \"idc\": null,\n" + "      \"code\": \"DILH\",\n" + "      \"libelle\": \"DIRM\",\n" + "      \"libelleAnglais\": null,\n" + "      \"libelleCourt\": \"DIRM\",\n" + "      \"dateDebutApplication\": \"2010-09-28\",\n" + "      \"dateFinApplication\": null,\n" + "      \"bloque\": false,\n" + "      \"codeExport\": \"DILH\"\n" + "    },\n" + "    \"listTitreCapacite\": [\n" + "\n" + "    ],\n" + "    \"listVisaCapacite\": null\n" + "  }";

                } else if (level.equals("2")) {
                    return "{\n" + "    \"idIteTitreDetenu\": 848912,\n" + "    \"idIteVisaAttestaion\": null,\n" + "    " + "\"numeroTitre\": \"10474236\",\n" + "    \"numeroVisa\": null,\n" + "    \"dateDelivrance\":" + " \"20/08/2020\",\n" + "    \"dateRevalidation\": null,\n" + "    \"dateEffet\": " + "\"24/06/2020\",\n" + "    \"dateExpiration\": null,\n" + "    \"codeEtatTitre\": {\n" + "   " + "   \"idc\": 3,\n" + "      \"code\": \"03\",\n" + "      \"libelle\": \"Valide\",\n" + "    " + "  \"libelleAnglais\": \"Valid\",\n" + "      \"libelleCourt\": null,\n" + "      " + "\"dateDebutApplication\": null,\n" + "      \"dateFinApplication\": null,\n" + "      " + "\"bloque\": false,\n" + "      \"codeExport\": null\n" + "    },\n" + "    \"codeEtatVisa\":" + " null,\n" + "    \"codeBrevetMarin\": {\n" + "      \"idc\": 250,\n" + "      \"code\": " + "\"9525\",\n" + "      \"libelle\": \"Certificat de matelot pont (2015)\",\n" + "      " + "\"libelleAnglais\": null,\n" + "      \"libelleCourt\": null,\n" + "      " + "\"dateDebutApplication\": \"2015-09-01\",\n" + "      \"dateFinApplication\": null,\n" + "  " + "    \"bloque\": false,\n" + "      \"codeExport\": null,\n" + "      \"codeFrmFamilleTitre" + "\": {\n" + "        \"idc\": 1,\n" + "        \"code\": \"BREVET\",\n" + "        " + "\"libelle\": \"Brevet\",\n" + "        \"libelleAnglais\": null,\n" + "        " + "\"libelleCourt\": null,\n" + "        \"dateDebutApplication\": null,\n" + "        " + "\"dateFinApplication\": null,\n" + "        \"bloque\": false,\n" + "        \"codeExport\":" + " null\n" + "      },\n" + "      \"infoBrevetPourPmrLong\": null\n" + "    },\n" + "    " + "\"codeAutoriteDelivrance\": {\n" + "      \"idc\": null,\n" + "      \"code\": \"DILH\",\n" + "      \"libelle\": \"DIRM\",\n" + "      \"libelleAnglais\": null,\n" + "      \"libelleCourt\": \"DIRM\",\n" + "      \"dateDebutApplication\": \"2010-09-28\",\n" + "      \"dateFinApplication\": null,\n" + "      \"bloque\": false,\n" + "      \"codeExport\": \"DILH\"\n" + "    },\n" + "    \"listTitreCapacite\": [\n" + "      {\n" + "        \"idIteTitreCapaciteRest\": 77777,\n" + "        \"restrictionLibre\": null,\n" + "        \"restrictionLibreAnglais\": null,\n" + "        \"idTitreDetenu\": null,\n" + "        \"codeFrmTitreCapaciteRestriction\": {\n" + "          \"idc\": 883,\n" + "          \"code\": \"864\",\n" + "          \"libelle\": \"Fonction d'appui sur navires armés au commerce ou à la plaisance avec ou sans tâches spécialisées à bord de navires de jauge brute inférieure à 500 ou sans tâches spécialisées à bord de navires de jauge brute égale ou supérieure à 500\",\n" + "          \"libelleAnglais\": \" Function at the support level with or without specialized duties on merchant ships or yachts of less than 500 gross tonnage or without specialized duties on ships of 500 gross tonnage or more\",\n" + "          \"libelleCourt\": null,\n" + "          \"dateDebutApplication\": \"2015-09-01\",\n" + "          \"dateFinApplication\": null,\n" + "          \"bloque\": false,\n" + "          \"codeExport\": null\n" + "        },\n" + "        \"codeFrmTitreCapaciteStwc\": {\n" + "          \"idc\": 42,\n" + "          \"code\": \"052\",\n" + "          \"libelle\": \"Matelot\",\n" + "          \"libelleAnglais\": \"Rating\",\n" + "          \"libelleCourt\": null,\n" + "          \"dateDebutApplication\": \"2011-06-30\",\n" + "          \"dateFinApplication\": null,\n" + "          \"bloque\": false,\n" + "          \"codeExport\": null\n" + "        }\n" + "      },\n" + "      {\n" + "        \"idIteTitreCapaciteRest\": 698668,\n" + "        \"restrictionLibre\": null,\n" + "        \"restrictionLibreAnglais\": null,\n" + "        \"idTitreDetenu\": null,\n" + "        \"codeFrmTitreCapaciteRestriction\": {\n" + "          \"idc\": 884,\n" + "          \"code\": \"865\",\n" + "          \"libelle\": \"Fonction d'appui avec ou sans tâches spécialisées sur navires de pêche\",\n" + "          \"libelleAnglais\": \"Function at the support level with or without specialized duties \",\n" + "          \"libelleCourt\": null,\n" + "          \"dateDebutApplication\": \"2015-08-01\",\n" + "          \"dateFinApplication\": null,\n" + "          \"bloque\": false,\n" + "          \"codeExport\": null\n" + "        },\n" + "        \"codeFrmTitreCapaciteStwc\": {\n" + "          \"idc\": 42,\n" + "          \"code\": \"052\",\n" + "          \"libelle\": \"Matelot\",\n" + "          \"libelleAnglais\": \"Rating\",\n" + "          \"libelleCourt\": null,\n" + "          \"dateDebutApplication\": \"2011-06-30\",\n" + "          \"dateFinApplication\": null,\n" + "          \"bloque\": false,\n" + "          \"codeExport\": null\n" + "        }\n" + "      }\n" + "    ],\n" + "    \"listVisaCapacite\": null\n" + "  }";

                }
            case "amfore":
                if (level.equals("1")) {
                    return "{\n" + "    \"libelleVersionFormation\": \"Formation de matelot Pont\",\n" + "    " +
                            "\"dateAcquisition\": \"2020-06-24\",\n" + "    \"dateFinValidite\": \"2025-06-23\",\n" + "    \"libelleModeAcquisition\": \"Evaluation\",\n" + "    \"libelleModuleUv\": \"P3–Appui-Exploitation/assist/entretien/répar\",\n" + "    \"libelleTypeFormation\": \"Formation modulaire\"\n" + "  }";
                }
            case "esculape":
                if (level.equals("1")) {
                    return "{\n" + "  \"dateFinDeValidite\": 1640905200000,\n" + "  \"rendezVous\": 1608073200000,\n" + "  \"decisionMedicale\": {\n" + "    \"idCode\": 1,\n" + "    \"code\": \"1\",\n" + "    \"libelle\": \"Apte TF/TN\",\n" + "    \"libelleAnglais\": null,\n" + "    \"libelleCourt\": null,\n" + "    \"dateDebutApplication\": 1241388000000,\n" + "    \"dateFinApplication\": null,\n" + "    \"bloque\": false,\n" + "    \"codeExport\": null\n" + "  },\n" + "  \"restrictionMedicale1\": null,\n" + "  \"restrictionMedicale2\": null,\n" + "  \"idMarin\": 346575\n" + "}";
                } else if (level.equals("2")) {
                    return "{\n" + "  \"dateFinDeValidite\": 1640905200000,\n" + "  \"rendezVous\": 1608073200000,\n" + "  \"decisionMedicale\": {\n" + "    \"idCode\": 1,\n" + "    \"code\": \"1\",\n" + "    \"libelle\": \"Apte TF/TN\",\n" + "    \"libelleAnglais\": null,\n" + "    \"libelleCourt\": null,\n" + "    \"dateDebutApplication\": 1241388000000,\n" + "    \"dateFinApplication\": null,\n" + "    \"bloque\": false,\n" + "    \"codeExport\": null\n" + "  },\n" + "  \"restrictionMedicale1\": null,\n" + "  \"restrictionMedicale2\": null,\n" + "  \"idMarin\": 346575\n" + "}";
                }
            default:
                return null;
        }
    }

}