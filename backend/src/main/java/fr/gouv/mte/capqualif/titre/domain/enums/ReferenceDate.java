package fr.gouv.mte.capqualif.titre.domain.enums;

import java.time.LocalDate;
import java.util.Objects;

public class ReferenceDate implements IReferenceDate {

    private LocalDate referenceDate;

    public ReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    @Override
    public String toString() {
        return "Date{" +
                "date=" + referenceDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ReferenceDate referenceDate1 = (ReferenceDate) o;
        return referenceDate.equals(referenceDate1.referenceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceDate);
    }
}
