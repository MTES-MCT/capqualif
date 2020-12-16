package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class DataChecker {
    // TO DO : add date check
    public boolean compareDataToCondition(List<String> data, ConditionTitre condition, LocalDate date) {

        boolean result = false;

        for(String element : data) {
            switch(condition.getCommentComparer()) {
                case "minimum":
                    Integer age = calculateYearsBetweenDateAndToday(element);
                    if (age > Integer.valueOf(condition.getValeur())) result = true;
                case "egaliteStricte":
                    if(element.equals(condition.getValeur())) result = true;
            }

        }
        return result;
    }

    private Integer calculateYearsBetweenDateAndToday(String dateFromMarinData) {
        LocalDate date = convertStringToLocalDate(dateFromMarinData);
        LocalDate today = LocalDate.now();
        if ((date != null)) {
            return Period.between(date, today).getYears();
        }
        return null;
    }

    private LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

}
