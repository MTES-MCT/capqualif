package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class DataChecker {
    // TO DO : add date check
    public boolean compareDataToCondition(Map<String, String> data, ConditionTitre condition, LocalDate date) {

        boolean result = false;

        switch (condition.getCommentComparer()) {
            case "minimum":
                Integer age = calculateYearsBetweenDateAndToday(data.get("simpleField"));
                if (age > Integer.parseInt(condition.getValeur())) result = true;
            case "egaliteStricte":
                if(data.containsKey("simpleField")) {
                    if(data.get("simpleField").equals(condition.getValeur()) && !isDataExpired(data.get("expirationField"))) result = true;
                }
                if(data.containsKey("nestedField")) {
                    if(data.get("nestedField").equals(condition.getValeur()) && !isDataExpired(data.get("expirationField"))) result = true;
                }
        }

//        for (String element : data) {
//            switch (condition.getCommentComparer()) {
//                case "minimum":
//                    Integer age = calculateYearsBetweenDateAndToday(element);
//                    if (age > Integer.valueOf(condition.getValeur())) result = true;
//                case "egaliteStricte":
//                    if(element.equals(condition.getValeur())) result = true;
//            }
//        }
        return result;
    }

    private boolean isDataExpired(String expirationDate) {
        boolean isDataExpired = false;
        LocalDate localExpirationDate = convertEpochDatetoLocalDate(expirationDate);
        int result = localExpirationDate.compareTo(LocalDate.now());
        if (result <= 0) isDataExpired = true;
        return isDataExpired;
    }


    private Integer calculateYearsBetweenDateAndToday(String dateFromMarinData) {
        LocalDate date = convertStringDateToLocalDate(dateFromMarinData);
        LocalDate today = LocalDate.now();
        if ((date != null)) {
            return Period.between(date, today).getYears();
        }
        return null;
    }

    private LocalDate convertStringDateToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }


    private LocalDate convertEpochDatetoLocalDate(String epochDate) {
        LocalDate localDate = Instant.ofEpochMilli(Long.parseLong(epochDate)).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

}
