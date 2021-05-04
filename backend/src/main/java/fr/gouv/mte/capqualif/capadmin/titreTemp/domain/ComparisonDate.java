package fr.gouv.mte.capqualif.capadmin.titreTemp.domain;

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
        return "ComparisonDate{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ComparisonDate that = (ComparisonDate) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
