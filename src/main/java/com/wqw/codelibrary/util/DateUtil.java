package com.wqw.codelibrary.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取今天开始时间
     * @return
     */
    public static String todayBeginTime(){

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        return localDateTime.format(formatter);

    }

    /**
     * 获取今天结束时间
     * @return
     */
    public static String todayEndTime(){

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        return localDateTime.format(formatter);

    }

    /**
     * 获取昨天开始时间
     * @return
     */
    public static String yesterdayBeginTime(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        localDateTime = localDateTime.plusDays(-1);
        return localDateTime.format(formatter);
    }

    /**
     * 获取昨天结束时间
     * @return
     */
    public static String yesterdayEndTime(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        localDateTime = localDateTime.plusDays(-1);
        return localDateTime.format(formatter);
    }

    /**
     * 获取本周开始时间
     * @return
     */
    public static String weekBeginTime(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        int dayOfWeek = localDateTime.getDayOfWeek().getValue();
        localDateTime = localDateTime.plusDays(-dayOfWeek+1);
        return localDateTime.format(formatter);
    }

    /**
     * 获取本周结束时间
     * @return
     */
    public static String weekEndTime(){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        int dayOfWeek = localDateTime.getDayOfWeek().getValue();
        localDateTime = localDateTime.plusDays(7-dayOfWeek);
        return localDateTime.format(formatter);
    }

    /**
     * 获取之前几周的开始时间
     * @return
     */
    public static String nWeekBeginTime(int weekNum){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        int dayOfWeek = localDateTime.getDayOfWeek().getValue();
        localDateTime = localDateTime.plusDays(-7*weekNum-dayOfWeek+1);
        return localDateTime.format(formatter);
    }

    /**
     * 获取之前几周的结束时间
     * @return
     */
    public static String nWeekEndTime(int weekNum){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        int dayOfWeek = localDateTime.getDayOfWeek().getValue();
        localDateTime = localDateTime.plusDays(-7*(weekNum-1)-dayOfWeek);
        return localDateTime.format(formatter);
    }

    /**
     * 获取本月开始时间
     * @return
     */
    public static String monthBeginTime(int n){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        if( n != 0){
            localDateTime = localDateTime.plusMonths(n);
        }
        localDateTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        return localDateTime.format(formatter);
    }

    /**
     * 获取本月结束时间
     * @return
     */
    public static String monthEndTime(int n){
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        if( n != 0){
            localDateTime = localDateTime.plusMonths(n);
        }
        localDateTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        return localDateTime.format(formatter);
    }


}

