package fr.gouv.mte.capqualif.domain.capQualif.instruction.domain;

import fr.gouv.mte.capqualif.domain.capAdmin.titre.domain.enums.DataType;

import java.util.Objects;

public class ExtractionResult {

    private String key;
    private String value;
    private DataType dataType;

    public ExtractionResult(String key, String value, DataType dataType) {
        this.key = key;
        this.value = Objects.requireNonNullElse(value, "null");
        this.dataType = dataType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public DataType getDataType() {
        return dataType;
    }

    @Override
    public String toString() {
        return "ExtractionResult{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", dataType=" + dataType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ExtractionResult that = (ExtractionResult) o;
        return key.equals(that.key) &&
                value.equals(that.value) &&
                dataType == that.dataType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, dataType);
    }
}
