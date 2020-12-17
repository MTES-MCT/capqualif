package fr.gouv.mte.capqualif.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Component
public class TimeConverter {

    public LocalDate convertToLocalDate(String date) {
        return isDateEpoch(date) ? convertEpochDatetoLocalDate(date) : convertStringDateToLocalDate(date);
    }

    private LocalDate convertStringDateToLocalDate(String date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .toFormatter();
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        return localDate;
    }

    private LocalDate convertEpochDatetoLocalDate(String epochDate) {
        LocalDate localDate = Instant.ofEpochMilli(Long.parseLong(epochDate)).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    private boolean isDateEpoch(String date) {
        int EPOCH_LENGTH = 10;
        if (date.length() == EPOCH_LENGTH && !date.contains("/") && !date.contains("-")) return true;

//        if (date.length() == EPOCH_LENGTH) {
//            if (!date.contains("/") && !date.contains("-")) return true;
//        }
        return false;
    }



}
