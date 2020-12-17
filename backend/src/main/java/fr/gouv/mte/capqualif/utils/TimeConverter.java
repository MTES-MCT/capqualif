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
        return LocalDate.parse(date, formatter);
    }

    private LocalDate convertEpochDatetoLocalDate(String epochDate) {
        return Instant.ofEpochMilli(Long.parseLong(epochDate)).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private boolean isDateEpoch(String date) {
        int EPOCH_LENGTH = 10;
        return date.length() >= EPOCH_LENGTH && !date.contains("/") && !date.contains("-");
    }

}
