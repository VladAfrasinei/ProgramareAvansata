package com;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public static void displayinformation(Locale locale) {
        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Currency: " + Currency.getInstance(locale));
        WeekFields wf = WeekFields.of(locale);
        DayOfWeek day = wf.getFirstDayOfWeek();
        for (int i = 0; i < DayOfWeek.values().length; i++) {
            System.out.println(day.getDisplayName(TextStyle.SHORT, locale) + " ");
            day = day.plus(1);
            DateFormatSymbols dfs = new DateFormatSymbols();
            String[] months = dfs.getMonths();
            System.out.printf("List of months: ");
            System.out.println(Arrays.toString(months));
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMM yyyy", locale);
            LocalDateTime now = LocalDateTime.now();
            System.out.println("");
            System.out.println("Today " + date.format(now));
        }
    }
}
