package fr.gouv.mte.capqualif.instructeur.application.services;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.shared.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataChecker {

    @Autowired
    TimeConverter timeConverter;

    public boolean compareDataToCondition(List<Map> dataList, ConditionTitre condition, LocalDate date) {

        List<Boolean> results = new ArrayList<>();

        for (Map data : dataList) {
            boolean singleCompareResult = false;

            switch (condition.getCommentComparer()) {
                case "minimum":
                    Integer age = calculateYearsBetweenDateAndToday(data.get("simpleField").toString());
                    if (age > Integer.parseInt(condition.getValeur())) singleCompareResult = true;
                case "egaliteStricte":
                    if(data.containsKey("simpleField")) {
                        if(data.get("simpleField").equals(condition.getValeur()) && !isDataExpired(data.get("expirationField").toString())) singleCompareResult = true;
                    }
                    if(data.containsKey("nestedField")) {
                        if(data.get("nestedField").equals(condition.getValeur()) && !isDataExpired(data.get("expirationField").toString())) singleCompareResult = true;
                    }
            }
            results.add(singleCompareResult);
        }
        if (results.contains(Boolean.TRUE)) return true;
        return false;
    }

    private boolean isDataExpired(String expirationDate) {
        boolean isDataExpired = false;
        LocalDate localExpirationDate = timeConverter.convertToLocalDate(expirationDate);
        int result = localExpirationDate.compareTo(LocalDate.now());
        if (result <= 0) isDataExpired = true;
        return isDataExpired;
    }

    private Integer calculateYearsBetweenDateAndToday(String dateFromMarinData) {
        LocalDate date = timeConverter.convertToLocalDate(dateFromMarinData);
        LocalDate today = LocalDate.now();
        if ((date != null)) {
            return Period.between(date, today).getYears();
        }
        return null;
    }
}
