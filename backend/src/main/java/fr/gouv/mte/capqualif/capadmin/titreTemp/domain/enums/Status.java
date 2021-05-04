package fr.gouv.mte.capqualif.capadmin.titreTemp.domain.enums;

import fr.gouv.mte.capqualif.capadmin.titreTemp.domain.ComparisonData;

public enum Status implements ComparisonData {
    // TO DO : check with experts

    VALID("Valide"),
    BLOCKED("Bloqué");

    private String statusValue;

    Status(String statusValue) {
        this.statusValue = statusValue;
    }

    @Override
    public String getValue() {
        return statusValue;
    }
}
