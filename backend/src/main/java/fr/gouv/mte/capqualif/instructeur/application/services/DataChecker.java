package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.utils.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class DataChecker {

    @Autowired
    TimeConverter timeConverter;

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
        return result;
    }

    private boolean isDataExpired(String expirationDate) {
        boolean isDataExpired = false;
        LocalDate localExpirationDate = timeConverter.convertEpochDatetoLocalDate(expirationDate);
        int result = localExpirationDate.compareTo(LocalDate.now());
        if (result <= 0) isDataExpired = true;
        return isDataExpired;
    }

    private Integer calculateYearsBetweenDateAndToday(String dateFromMarinData) {
        LocalDate date = timeConverter.convertStringDateToLocalDate(dateFromMarinData);
        LocalDate today = LocalDate.now();
        if ((date != null)) {
            return Period.between(date, today).getYears();
        }
        return null;
    }
}
