package com.neoflex.testtask.util;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class VacationDayUtil {
    private static List<LocalDate> holidays(int currentYear) {
        return List.of(
                LocalDate.of(currentYear, 1, 1),
                LocalDate.of(currentYear, 1, 2),
                LocalDate.of(currentYear, 1, 3),
                LocalDate.of(currentYear, 1, 4),
                LocalDate.of(currentYear, 1, 5),
                LocalDate.of(currentYear, 1, 6),
                LocalDate.of(currentYear, 1, 8),
                LocalDate.of(currentYear, 1, 7),
                LocalDate.of(currentYear, 2, 23),
                LocalDate.of(currentYear, 3, 8),
                LocalDate.of(currentYear, 5, 1),
                LocalDate.of(currentYear, 5, 9),
                LocalDate.of(currentYear, 6, 12),
                LocalDate.of(currentYear, 11, 4));
    }

    public static int getPaidDaysNumber(int vacationDaysNumber, LocalDate vacationStartDate) {
        return (int) Stream.iterate(vacationStartDate, date -> date.plusDays(1))
                .limit(vacationDaysNumber)
                .filter(date -> !holidays(vacationStartDate.getYear()).contains(date))
                .filter(date -> !(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)))
                .count();
    }

}
