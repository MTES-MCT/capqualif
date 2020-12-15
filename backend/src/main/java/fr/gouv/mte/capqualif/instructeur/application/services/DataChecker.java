package fr.gouv.mte.capqualif.instructeur.application.services;

import java.time.LocalDate;
import java.util.List;

public class DataChecker {
    // TO DO : add data check
    public boolean checkDataValidity(List<String> data, String conditionValeur, LocalDate date) {
        boolean result = false;
        for(String element : data) {
            if(element == conditionValeur) {
                result = true;
            }
        }
        return result;
    }

}
