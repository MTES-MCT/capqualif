package fr.gouv.mte.capqualif.capqualif.instruction.domain.marinData;

public class Age extends MarinData {

    public Age(String birthDate) {
        this.value = computeAge(birthDate);
    }

    private String computeAge(String birthDate) {
        /**
         * TODO : compute age
         */
        return "33";
    }

    @Override
    public String toString() {
        return "Age{" +
                "value='" + value + '\'' +
                '}';
    }
}
