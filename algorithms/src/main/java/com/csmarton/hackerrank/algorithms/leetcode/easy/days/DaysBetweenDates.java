package com.csmarton.hackerrank.algorithms.leetcode.easy.days;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DaysBetweenDates {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public int daysBetweenDates(String date1, String date2) {
        Long endDate = LocalDate.parse(date2, formatter).atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        Long date = LocalDate.parse(date1, formatter).atStartOfDay(ZoneId.systemDefault()).toEpochSecond();;

        return  (int)(Math.abs(endDate - date) / 60 / 60 / 24);
    }

}
