package fr.gouv.mte.capqualif.shared;

import com.google.json.JsonSanitizer;

public class JsonSanitization {

    // TO DO : add more sanitization

    public String sanitize(String unsanitizedJson) {
        return JsonSanitizer.sanitize(unsanitizedJson);
    }

}
