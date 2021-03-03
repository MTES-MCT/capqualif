package fr.gouv.mte.capqualif.shared;

import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.*;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonExtractorTest {

    JsonExtractor jsonExtractor;

    @BeforeEach
    void setUp() {
        jsonExtractor = new JsonExtractor();
    }

    @Test
    void getData_notNested() {
        // Given
        String json = "{\n" +
                "  \"dateFinDeValidite\": 1640905200000,\n" +
                "  \"rendezVous\": 1608073200000,\n" +
                "  \"decisionMedicale\": {\n" +
                "    \"idCode\": 1,\n" +
                "    \"code\": \"1\",\n" +
                "    \"libelle\": \"Apte TF/TN\",\n" +
                "    \"libelleAnglais\": null,\n" +
                "    \"libelleCourt\": null,\n" +
                "    \"dateDebutApplication\": 1241388000000,\n" +
                "    \"dateFinApplication\": null,\n" +
                "    \"bloque\": false,\n" +
                "    \"codeExport\": null\n" +
                "  },\n" +
                "  \"restrictionMedicale1\": null,\n" +
                "  \"restrictionMedicale2\": null,\n" +
                "  \"idMarin\": 123\n" +
                "}";

        DataToExtractFromExistingDataSource data = new DataToExtractFromExistingDataSource(
                ExistingDataSourceName.ESCULAPE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                "Aptitude médicale",
                                "libelle",
                                DataType.STRING),
                        new ValueInExistingDataSource("Apte TF/TN"), DataType.STRING
                ),
                Arrays.asList(new KeyInExistingDataSource(
                        "Date de fin de validité",
                        "dateFinDeValidite",
                        DataType.DATE))
        );

        // When
        List<ExtractionResult> actualResult = jsonExtractor.getAllWantedData(json, data);

        // Then

        List<ExtractionResult> expectedResult = Arrays.asList(
                new ExtractionResult(
                        "Aptitude médicale",
                        "Apte TF/TN",
                        DataType.STRING
                ),
                new ExtractionResult(
                        "Date de fin de validité",
                        "1640905200000",
                        DataType.DATE
                )
        );
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getData_nested() {
        // Given

        String json = "[\n" +
                "  {\n" +
                "    \"idIteTitreDetenu\": 839308,\n" +
                "    \"idIteVisaAttestaion\": null,\n" +
                "    \"numeroTitre\": \"123\",\n" +
                "    \"numeroVisa\": null,\n" +
                "    \"dateDelivrance\": \"09/04/2020\",\n" +
                "    \"dateRevalidation\": null,\n" +
                "    \"dateEffet\": \"12/02/2020\",\n" +
                "    \"dateExpiration\": \"11/02/2025\",\n" +
                "    \"codeEtatTitre\": {\n" +
                "      \"idc\": 3,\n" +
                "      \"code\": \"03\",\n" +
                "      \"libelle\": \"Valide\",\n" +
                "      \"libelleAnglais\": \"Valid\",\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": null,\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": {\n" +
                "        \"niveau1\": {\n" +
                "          \"blabl\": \"blibli\",\n" +
                "          \"niveau2\": {\n" +
                "            \"blabl\": \"blibli\",\n" +
                "            \"ceQueJeVeuxKey\": \"douzigi winner\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"codeEtatVisa\": null,\n" +
                "    \"codeBrevetMarin\": {\n" +
                "      \"idc\": 243,\n" +
                "      \"code\": \"9556\",\n" +
                "      \"libelle\": \"Certificat de formation de base à la sécurité (STCW10)\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": \"2013-07-26\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null,\n" +
                "      \"codeFrmFamilleTitre\": {\n" +
                "        \"idc\": 3,\n" +
                "        \"code\": \"CERTIFICAT\",\n" +
                "        \"libelle\": \"Certificat\",\n" +
                "        \"libelleAnglais\": null,\n" +
                "        \"libelleCourt\": null,\n" +
                "        \"dateDebutApplication\": null,\n" +
                "        \"dateFinApplication\": null,\n" +
                "        \"bloque\": false,\n" +
                "        \"codeExport\": null\n" +
                "      },\n" +
                "      \"infoBrevetPourPmrLong\": null\n" +
                "    },\n" +
                "    \"codeAutoriteDelivrance\": {\n" +
                "      \"idc\": null,\n" +
                "      \"code\": \"DILH\",\n" +
                "      \"libelle\": \"DIRM\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": \"DIRM\",\n" +
                "      \"dateDebutApplication\": \"2010-09-28\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": \"DILH\"\n" +
                "    },\n" +
                "    \"listTitreCapacite\": [\n" +
                "      \n" +
                "    ],\n" +
                "    \"listVisaCapacite\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"idIteTitreDetenu\": 666,\n" +
                "    \"idIteVisaAttestaion\": null,\n" +
                "    \"numeroTitre\": \"10463946\",\n" +
                "    \"numeroVisa\": null,\n" +
                "    \"dateDelivrance\": \"09/04/2020\",\n" +
                "    \"dateRevalidation\": null,\n" +
                "    \"dateEffet\": \"13/02/2020\",\n" +
                "    \"dateExpiration\": \"12/02/2025\",\n" +
                "    \"codeEtatTitre\": {\n" +
                "      \"idc\": 3,\n" +
                "      \"code\": \"03\",\n" +
                "      \"libelle\": \"Valide\",\n" +
                "      \"libelleAnglais\": \"Valid\",\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": null,\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null\n" +
                "    },\n" +
                "    \"codeEtatVisa\": null,\n" +
                "    \"codeBrevetMarin\": {\n" +
                "      \"idc\": 201,\n" +
                "      \"code\": \"7758\",\n" +
                "      \"libelle\": \"Enseignement médical de niveau I\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": \"2012-06-04\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null,\n" +
                "      \"codeFrmFamilleTitre\": {\n" +
                "        \"idc\": 3,\n" +
                "        \"code\": \"CERTIFICAT\",\n" +
                "        \"libelle\": \"Certificat\",\n" +
                "        \"libelleAnglais\": null,\n" +
                "        \"libelleCourt\": null,\n" +
                "        \"dateDebutApplication\": null,\n" +
                "        \"dateFinApplication\": null,\n" +
                "        \"bloque\": false,\n" +
                "        \"codeExport\": null\n" +
                "      },\n" +
                "      \"infoBrevetPourPmrLong\": null\n" +
                "    },\n" +
                "    \"codeAutoriteDelivrance\": {\n" +
                "      \"idc\": null,\n" +
                "      \"code\": \"DILH\",\n" +
                "      \"libelle\": \"DIRM\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": \"DIRM\",\n" +
                "      \"dateDebutApplication\": \"2010-09-28\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": \"DILH\"\n" +
                "    },\n" +
                "    \"listTitreCapacite\": [\n" +
                "      \n" +
                "    ],\n" +
                "    \"listVisaCapacite\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"idIteTitreDetenu\": 888,\n" +
                "    \"idIteVisaAttestaion\": null,\n" +
                "    \"numeroTitre\": \"10469394\",\n" +
                "    \"numeroVisa\": null,\n" +
                "    \"dateDelivrance\": \"07/07/2020\",\n" +
                "    \"dateRevalidation\": null,\n" +
                "    \"dateEffet\": \"06/02/2020\",\n" +
                "    \"dateExpiration\": null,\n" +
                "    \"codeEtatTitre\": {\n" +
                "      \"idc\": 3,\n" +
                "      \"code\": \"03\",\n" +
                "      \"libelle\": \"Valide\",\n" +
                "      \"libelleAnglais\": \"Valid\",\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": null,\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null\n" +
                "    },\n" +
                "    \"codeEtatVisa\": null,\n" +
                "    \"codeBrevetMarin\": {\n" +
                "      \"idc\": 229,\n" +
                "      \"code\": \"9554\",\n" +
                "      \"libelle\": \"Certificat de sensibilisation à la sûreté (STCW10)\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": \"2012-11-30\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null,\n" +
                "      \"codeFrmFamilleTitre\": {\n" +
                "        \"idc\": 3,\n" +
                "        \"code\": \"CERTIFICAT\",\n" +
                "        \"libelle\": \"Certificat banana split\",\n" +
                "        \"libelleAnglais\": null,\n" +
                "        \"libelleCourt\": null,\n" +
                "        \"dateDebutApplication\": null,\n" +
                "        \"dateFinApplication\": null,\n" +
                "        \"bloque\": false,\n" +
                "        \"codeExport\": null\n" +
                "      },\n" +
                "      \"infoBrevetPourPmrLong\": null\n" +
                "    },\n" +
                "    \"codeAutoriteDelivrance\": {\n" +
                "      \"idc\": null,\n" +
                "      \"code\": \"DILH\",\n" +
                "      \"libelle\": \"DIRM NEVERLAND\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": \"DIRM\",\n" +
                "      \"dateDebutApplication\": \"2010-09-28\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": \"DILH\"\n" +
                "    },\n" +
                "    \"listTitreCapacite\": [\n" +
                "      \n" +
                "    ],\n" +
                "    \"listVisaCapacite\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"idIteTitreDetenu\": 848912,\n" +
                "    \"idIteVisaAttestaion\": null,\n" +
                "    \"numeroTitre\": \"10474236\",\n" +
                "    \"numeroVisa\": null,\n" +
                "    \"dateDelivrance\": \"20/08/2020\",\n" +
                "    \"dateRevalidation\": null,\n" +
                "    \"dateEffet\": \"24/06/2020\",\n" +
                "    \"dateExpiration\": null,\n" +
                "    \"codeEtatTitre\": {\n" +
                "      \"idc\": 3,\n" +
                "      \"code\": \"03\",\n" +
                "      \"libelle\": \"Valide\",\n" +
                "      \"libelleAnglais\": \"Valid\",\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": null,\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null\n" +
                "    },\n" +
                "    \"codeEtatVisa\": null,\n" +
                "    \"codeBrevetMarin\": {\n" +
                "      \"idc\": 250,\n" +
                "      \"code\": \"9525\",\n" +
                "      \"libelle\": \"Certificat de matelot pont (2015)\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": null,\n" +
                "      \"dateDebutApplication\": \"2015-09-01\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": null,\n" +
                "      \"codeFrmFamilleTitre\": {\n" +
                "        \"idc\": 1,\n" +
                "        \"code\": \"BREVET\",\n" +
                "        \"libelle\": \"Brevet\",\n" +
                "        \"libelleAnglais\": null,\n" +
                "        \"libelleCourt\": null,\n" +
                "        \"dateDebutApplication\": null,\n" +
                "        \"dateFinApplication\": null,\n" +
                "        \"bloque\": false,\n" +
                "        \"codeExport\": null\n" +
                "      },\n" +
                "      \"infoBrevetPourPmrLong\": null\n" +
                "    },\n" +
                "    \"codeAutoriteDelivrance\": {\n" +
                "      \"idc\": null,\n" +
                "      \"code\": \"DILH\",\n" +
                "      \"libelle\": \"DIRM\",\n" +
                "      \"libelleAnglais\": null,\n" +
                "      \"libelleCourt\": \"DIRM\",\n" +
                "      \"dateDebutApplication\": \"2010-09-28\",\n" +
                "      \"dateFinApplication\": null,\n" +
                "      \"bloque\": false,\n" +
                "      \"codeExport\": \"DILH\"\n" +
                "    },\n" +
                "    \"listTitreCapacite\": [\n" +
                "      {\n" +
                "        \"idIteTitreCapaciteRest\": 77777,\n" +
                "        \"restrictionLibre\": null,\n" +
                "        \"restrictionLibreAnglais\": null,\n" +
                "        \"idTitreDetenu\": null,\n" +
                "        \"codeFrmTitreCapaciteRestriction\": {\n" +
                "          \"idc\": 883,\n" +
                "          \"code\": \"864\",\n" +
                "          \"libelle\": \"Fonction d'appui sur navires armés au commerce ou à la plaisance avec ou " +
                "sans tâches spécialisées à bord de navires de jauge brute inférieure à 500 ou sans tâches " +
                "spécialisées à bord de navires de jauge brute égale ou supérieure à 500\",\n" +
                "          \"libelleAnglais\": \" Function at the support level with or without specialized duties on" +
                " merchant ships or yachts of less than 500 gross tonnage or without specialized duties on ships of " +
                "500 gross tonnage or more\",\n" +
                "          \"libelleCourt\": null,\n" +
                "          \"dateDebutApplication\": \"2015-09-01\",\n" +
                "          \"dateFinApplication\": null,\n" +
                "          \"bloque\": false,\n" +
                "          \"codeExport\": null\n" +
                "        },\n" +
                "        \"codeFrmTitreCapaciteStwc\": {\n" +
                "          \"idc\": 42,\n" +
                "          \"code\": \"052\",\n" +
                "          \"libelle\": \"Matelot\",\n" +
                "          \"libelleAnglais\": \"Rating\",\n" +
                "          \"libelleCourt\": null,\n" +
                "          \"dateDebutApplication\": \"2011-06-30\",\n" +
                "          \"dateFinApplication\": null,\n" +
                "          \"bloque\": false,\n" +
                "          \"codeExport\": null\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"idIteTitreCapaciteRest\": 698668,\n" +
                "        \"restrictionLibre\": null,\n" +
                "        \"restrictionLibreAnglais\": null,\n" +
                "        \"idTitreDetenu\": null,\n" +
                "        \"codeFrmTitreCapaciteRestriction\": {\n" +
                "          \"idc\": 884,\n" +
                "          \"code\": \"865\",\n" +
                "          \"libelle\": \"Fonction d'appui avec ou sans tâches spécialisées sur navires de pêche\",\n" +
                "          \"libelleAnglais\": \"Function at the support level with or without specialized duties \"," +
                "\n" +
                "          \"libelleCourt\": null,\n" +
                "          \"dateDebutApplication\": \"2015-08-01\",\n" +
                "          \"dateFinApplication\": null,\n" +
                "          \"bloque\": false,\n" +
                "          \"codeExport\": null\n" +
                "        },\n" +
                "        \"codeFrmTitreCapaciteStwc\": {\n" +
                "          \"idc\": 42,\n" +
                "          \"code\": \"052\",\n" +
                "          \"libelle\": \"Matelot\",\n" +
                "          \"libelleAnglais\": \"Rating\",\n" +
                "          \"libelleCourt\": null,\n" +
                "          \"dateDebutApplication\": \"2011-06-30\",\n" +
                "          \"dateFinApplication\": null,\n" +
                "          \"bloque\": false,\n" +
                "          \"codeExport\": null\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"listVisaCapacite\": null\n" +
                "  }\n" +
                "]";

        DataToExtractFromExistingDataSource data = new DataToExtractFromExistingDataSource(
                ExistingDataSourceName.ITEM,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                "Certificat de formation de base à la sécurité (CFBS)",
                                "libelle",
                                true,
                                Collections.singletonList(new ParentKey(Position.POSITION_1, "codeBrevetMarin")
                                )
                        ),
                        new ValueInExistingDataSource(
                                "Certificat de formation de base à la sécurité (STCW10)"
                        ),
                        DataType.STRING
                ),
                Arrays.asList(
                        new KeyInExistingDataSource(
                                "Date de fin de validité",
                                "dateExpiration",
                                DataType.DATE),
                        new KeyInExistingDataSource(
                                "statut",
                                "libelle",
                                DataType.STRING,
                                true,
                                Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                        )
                )
        );

        // When
        List<ExtractionResult> actualResult = jsonExtractor.getAllWantedData(json, data);

        // Then

        List<ExtractionResult> expectedResult = Arrays.asList(
                new ExtractionResult(
                        "Certificat de formation de base à la sécurité (CFBS)",
                        "Certificat de formation de base à la sécurité (STCW10)",
                        DataType.STRING
                ),
                new ExtractionResult(
                        "Statut",
                        "Valide",
                        DataType.STRING
                ),
                new ExtractionResult(
                        "Date de fin de validité",
                        "11/02/2025",
                        DataType.DATE
                )
        );

        assertEquals(expectedResult, actualResult);

    }
}