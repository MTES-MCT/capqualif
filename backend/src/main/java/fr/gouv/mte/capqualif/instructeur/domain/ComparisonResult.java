package fr.gouv.mte.capqualif.instructeur.domain;

import java.util.Objects;

public class ComparisonResult {

    private String name;
    private boolean isValid;

    public ComparisonResult(String name, boolean isValid) {
        this.name = name;
        this.isValid = isValid;
    }

    public String getName() {
        return name;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonResult result = (ComparisonResult) o;
        return isValid == result.isValid &&
                name.equals(result.name);
    }
}
