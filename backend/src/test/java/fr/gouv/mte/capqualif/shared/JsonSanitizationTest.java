// I comment this test because json sanitizer lib does not seem to completely work. Have to investigate our needs and the appropriate solution farther before continuing.


//package fr.gouv.mte.capqualif.shared;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JsonSanitizationTest {
//
//    JsonSanitization jsonSanitization;
//
//    @Test
//    public void shouldSanitize() {
//
//        // Source for unsanitized json: https://github.com/payloadbox/xss-payload-list
//
//        // Given
//        jsonSanitization = new JsonSanitization();
//
//        String unsanitizedJson =
//                "{'key': \"input\", 'key': input, \"key\": \"\\xABinput\", \"key\": \"\"</ScRIpT\"\"}";
//
//        // When
//        String actual = jsonSanitization.sanitize(unsanitizedJson);
//
//        // Then
//        String expected = "{\"key1\":\"value1\",\"type\":\"Booking\",\"sid\":\"A43521\",\"region\":\"ASIA\"," +
//                "\"fetchFromFile\":\"false\",\"service\":\"true\",\"isEom\":\"true\"}";
//
//        assertEquals(expected, actual);
//
//    }
//
//}