package fr.gouv.mte.capqualif.legislateur.adapters.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.legislateur.domain.Operations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesControllerTest {


    @Test
    void testAllIsOk() throws JsonProcessingException {
        // Given
        String json = "{\n" +
                "  \"titre\": \"Matelot Pont\",\n" +
                "  \"operations\": [\n" +
                "    {\n" +
                "      \"id\": \"0\",\n" +
                "      \"operationType\": \"ATOMIC\",\n" +
                "      \"operator\": \"AND\",\n" +
                "      \"subOperations\": [\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"16\",\n" +
                "          \"rightOp\": \"16\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"operationType\": \"ATOMIC\",\n" +
                "      \"operator\": \"AND\",\n" +
                "      \"subOperations\": [\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"apte toutes fonctions, toutes navigations\",\n" +
                "          \"rightOp\": \"apte toutes fonctions, toutes navigations\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"operationType\": \"ATOMIC\",\n" +
                "      \"operator\": \"AND\",\n" +
                "      \"subOperations\": [\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Module P1-Appui navigation\",\n" +
                "          \"rightOp\": \"Module P1-Appui navigation\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Module P2-Appui manutention et arrimage de la cargaison, pêche\",\n" +
                "          \"rightOp\": \"Module P2-Appui manutention et arrimage de la cargaison, pêche\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Module P3-Appui contrôle de l’exploitation du navire et assistance aux personnes" +
                " à bord, entretien et réparation\",\n" +
                "          \"rightOp\": \"Module P3-Appui contrôle de l’exploitation du navire et assistance aux " +
                "personnes à bord, entretien et réparation\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Module NP-Appui module National Pont\",\n" +
                "          \"rightOp\": \"Module NP-Appui module National Pont\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"operationType\": \"ATOMIC\",\n" +
                "      \"operator\": \"OR\",\n" +
                "      \"subOperations\": [\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Certificat de fin d’études maritimes de matelot, de marin du commerce ou pêche " +
                "délivré conformément à l’arrêté du 12 décembre 2006 susvisé\",\n" +
                "          \"rightOp\": \"Certificat de fin d’études maritimes de matelot, de marin du commerce ou pêche " +
                "délivré conformément à l’arrêté du 12 décembre 2006 susvisé\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Certificat d’aptitude professionnelle maritime de matelot délivré conformément à" +
                " l’arrêté du 8 septembre 2005 susvisé\",\n" +
                "          \"rightOp\": \"Certificat d’aptitude professionnelle maritime de matelot délivré conformément " +
                "à l’arrêté du 8 septembre 2005 susvisé\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Brevet d’études professionnelles maritimes spécialité marin de commerce délivré " +
                "conformément à l’arrêté du 22 décembre 2009\",\n" +
                "          \"rightOp\": \"Brevet d’études professionnelles maritimes spécialité marin de commerce délivré" +
                " conformément à l’arrêté du 22 décembre 2009\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"operator\": \"==\",\n" +
                "          \"leftOp\": \"Brevet d’études professionnelles maritimes spécialité pêche délivré conformément" +
                " à l’arrêté du 22 décembre 2009\",\n" +
                "          \"rightOp\": \"Brevet d’études professionnelles maritimes spécialité pêche délivré " +
                "conformément à l’arrêté du 22 décembre 2009\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"operationType\": \"INTERMEDIATE\",\n" +
                "      \"operator\": \"OR\",\n" +
                "      \"comparedIntermediateResultsOfOperations\": [\n" +
                "        \"2\",\n" +
                "        \"3\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5\",\n" +
                "      \"operationType\": \"FINAL\",\n" +
                "      \"operator\": \"AND\",\n" +
                "      \"comparedIntermediateResultsOfOperations\": [\n" +
                "        \"0\",\n" +
                "        \"1\",\n" +
                "        \"3\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Operations operations = objectMapper.readValue(json, Operations.class);
        System.out.println(operations);


        // When




        // Then

    }


}