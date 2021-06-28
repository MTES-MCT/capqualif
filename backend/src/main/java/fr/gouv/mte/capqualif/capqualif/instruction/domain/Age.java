package fr.gouv.mte.capqualif.capqualif.instruction.domain;

public class Age extends MarinData {

    private String age;

    public Age(String birthDate) {
        this.age = computeAge(birthDate);
    }

    public String getAge() {
        return age;
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
                "age='" + age + '\'' +
                '}';
    }
}
