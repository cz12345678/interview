package com.thunisoft.my.util;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

/**
 * @author chenzhen-1
 * @create 2019-07-05 19:05
 */
public class DateCorvertUtils {


    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 返回当前的日期
     *
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 返回当前日期字符串 yyyyMMdd
     *
     * @return
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 返回当前日期时间字符串 yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 将日期字符串格式化成对应的格式
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将日期时间字符串格式化成对应的格式
     * @param dateTimeStr
     * @param pattern
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取本月的第一天
     *
     * @return
     */
    public static String getFirstDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取本月的最后一天
     *
     * @return
     */
    public static String getLastDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取 月初
     * @param date
     * @return
     */
    public static LocalDate getFirstDayOfMonth(LocalDate date){
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取 月末
     * @param date
     * @return
     */
    public static LocalDate getLastDayOfMonth(LocalDate date){
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }



    /**
     * 获取 月 的第一个周一
     * @param date
     * @return
     */
    public static LocalDate getFirstMondayOfMonth(LocalDate date){
        return date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    /**
     * 获取 年 的第一个周一
     * @param date
     * @return
     */
    public static LocalDate getFirstMondayOfYear(LocalDate date){
        return date.with(TemporalAdjusters.firstDayOfYear()).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    @Test
    public void test(){
        System.out.println(getFirstMondayOfMonth(LocalDate.now()));
        System.out.println(getCurDateAfterNWeek(1));
    }



    /**
     * 获取当前日期的后N周
     *
     * @return
     */
    public static LocalDate getCurDateAfterNWeek(int number){
        return getCurrentLocalDate().plus(number,ChronoUnit.WEEKS);
    }


    /**
     * 获取当前日期的N个月后的日期
     * @param number
     * @return
     */
    public static LocalDate getCurDateAfterNMonth(int number){
        return getCurrentLocalDate().plus(number, ChronoUnit.MONTHS);
    }



    /**
     * 获取当前日期的N年后的日期
     * @param number
     * @return
     */
    public static LocalDate getCurDateAfterNYear(int number){
        return getCurrentLocalDate().plus(number, ChronoUnit.YEARS);
    }


	/**
	 * 获得当前季度开始时间
	 *
	 * @return
	 */
	public static LocalDateTime getCurrentQuarterStartTime01() {
		LocalDate date = LocalDate.now();
		Month firstMonthOfQuarter = date.getMonth().firstMonthOfQuarter();
		LocalDateTime start = LocalDateTime.of(LocalDate.of(date.getYear(), firstMonthOfQuarter, 1), LocalTime.MIN);		
		return start;		
	}
	
		/**
	 * 获得当季度结束时间
	 *
	 * @return
	 */
	public static LocalDateTime getCurrentQuarterEndTime01() {
		LocalDate date = LocalDate.now();
		Month firstMonthOfQuarter = date.getMonth().firstMonthOfQuarter();
		Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
		LocalDateTime end = LocalDateTime.of(LocalDate.of(date.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(date.isLeapYear())),LocalTime.MAX);
		return end;
	}



}
