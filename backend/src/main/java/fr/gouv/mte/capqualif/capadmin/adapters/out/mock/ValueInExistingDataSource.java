package fr.gouv.mte.capqualif.capAdmin.adapters.out.mock;

import java.util.Objects;

public class ValueInExistingDataSource {
    private String content;

    public ValueInExistingDataSource(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "ValueInExistingDataSource{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ValueInExistingDataSource that = (ValueInExistingDataSource) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
