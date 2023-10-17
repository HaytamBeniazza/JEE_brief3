package Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tools {

    public static LocalDate convertStringToDate(String dateString) {
        return convertStringToDate(dateString, "dd-MM-yyyy");
    }

    public static LocalDate convertStringToDate(String dateString, String dateFormatPattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern);
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            // Handle parsing exception as needed
            e.printStackTrace();
            return null;
        }
    }
}
