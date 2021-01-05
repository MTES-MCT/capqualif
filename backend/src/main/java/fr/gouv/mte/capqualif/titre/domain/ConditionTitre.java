package fr.gouv.mte.capqualif.titre.domain;

public class ConditionTitre {

    private String name;
    private Value value;
    private ComparisonType howToCompareValue;
    private String existingDataSource;

    public ConditionTitre(String name, Value value, ComparisonType howToCompareValue, String existingDataSource) {
        this.name = name;
        this.value = value;
        this.howToCompareValue = howToCompareValue;
        this.existingDataSource = existingDataSource;
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    public ComparisonType getHowToCompareValue() {
        return howToCompareValue;
    }

    public String getExistingDataSource() {
        return existingDataSource;
    }
}
