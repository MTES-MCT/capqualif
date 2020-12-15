package fr.gouv.mte.capqualif.instructeur.application.services;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataChecker {
    // TO DO : add data check
    public boolean checkDataValidity(List<String> data, String conditionValeur, LocalDate date) {
        boolean result = false;
        for(String element : data) {
            if(element.equals(conditionValeur)) {
                result = true;
            }
        }
        return result;
    }

}
