package fr.gouv.mte.capqualif.titre.domain.enums;

import java.time.LocalDate;
import java.util.Objects;

public class ComparisonDate implements ComparisonData {

    private LocalDate data;

    public ComparisonDate(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String getValue() {
        return data.toString();
    }

    @Override
    public String toString() {
        return "Date{" +
                "date=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonDate referenceDate1 = (ComparisonDate) o;
        return data.equals(referenceDate1.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

}
