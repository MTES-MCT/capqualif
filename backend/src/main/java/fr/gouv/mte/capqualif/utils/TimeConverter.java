package fr.gouv.mte.capqualif.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Component
public class TimeConverter {

    public LocalDate convertStringDateToLocalDate(String date) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .toFormatter();
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        return localDate;
    }

    public LocalDate convertEpochDatetoLocalDate(String epochDate) {
        LocalDate localDate = Instant.ofEpochMilli(Long.parseLong(epochDate)).atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }



}
