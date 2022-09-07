package utils.exception.check.task6;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidateDate {
    public static LocalDate validateDateFormat(String date) {
        try {
            String pattern = "dd/MM/uuuu";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return null;
        } catch (Exception e) {
            return null;
        }

    }

    public static int validateAge(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears();
    }

    public static boolean validateDate(LocalDate date, String min, String max) {
        String pattern = "dd/MM/uuuu";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
        LocalDate minDate = LocalDate.parse(min, formatter);
        LocalDate maxDate = LocalDate.parse(max, formatter);
        return date.isBefore(minDate) || date.isAfter(maxDate);

    }
    public static boolean validateEndDate(String startDate, LocalDate endDate){
        String pattern = "dd/MM/uuuu";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
        LocalDate lcStartDate = LocalDate.parse(startDate,formatter);
        return endDate.isAfter(lcStartDate);
    }
    public static boolean validateStartDate(LocalDate startDate){
        LocalDate now = LocalDate.now();
        return startDate.isAfter(now);
    }
}
