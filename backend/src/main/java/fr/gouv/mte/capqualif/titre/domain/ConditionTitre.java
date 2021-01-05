package fr.gouv.mte.capqualif.titre.domain;

public class ConditionTitre {

    private String name;
    private String value;
    private ComparisonType howToCompareValue;
    private String existingDataSource;

    public ConditionTitre(String name, String value, ComparisonType howToCompareValue, String existingDataSource) {
        this.name = name;
        this.value = value;
        this.howToCompareValue = howToCompareValue;
        this.existingDataSource = existingDataSource;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public ComparisonType getHowToCompareValue() {
        return howToCompareValue;
    }

    public String getExistingDataSource() {
        return existingDataSource;
    }
}
