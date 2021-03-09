package fr.gouv.mte.capqualif.titre.domain.enums;

import java.util.Objects;

public class ReferenceString implements IReferenceString {

    private String reference;

    public ReferenceString(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        return "ReferenceString{" +
                "reference='" + reference + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ReferenceString that = (ReferenceString) o;
        return reference.equals(that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
}
