package com.thunisoft.my.util;

import org.apache.commons.lang.StringUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author chenzhen-1
 * @create 2019-07-05 10:54
 */
public class ConvertTypeUtil {

    private final static String DATATIME_FORMAT =  "yyyy-MM-dd HH:mm:ss";

    /**
     * 将Object转换成String
     * @param obj 对象
     * @return
     * @throws ParseException
     */
    public static String objToString(Object obj) throws ParseException {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Date)) {
            return String.valueOf(obj);
        }else {
            return customFormatDateString(obj, null);
        }
    }

    /**
     * 将String转换为Integer
     * @param str 值
     * @return
     */
    public static Integer stringToInteger(String str) {
        Integer num = Integer.valueOf(str);
        return num;
    }

    /**
     * 将String 转换为Long
     * @param str 值
     *
     * @return
     */
    public static long stringToLong(String str) {
        long lon = Long.valueOf(str);
        return lon;
    }

    /**
     * 将String 转换为Float
     * @param str 值
     * @return
     */
    public static float stringToFloat(String str) {
        float fl = Float.valueOf(str);
        return fl;
    }

    /**
     * 将String 转换为Double
     * @param str 值
     * @return
     */
    public static double stringToDouble(String str) {
        double dou = Double.valueOf(str);
        return dou;
    }

    /**
     * 字符串转换成日期
     * @param str 值
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return new Date(format.parse(str).getTime());
    }

    /**
     * 字符串转换成日期
     * @param str 值
     * @return
     * @throws ParseException
     */
    public static java.util.Date stringToDateTime(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp date = new Timestamp(format.parse(str).getTime());
        return date;
    }

    /**
     * 自定义格式化日期串
     * @param obj 日期类型
     * @param formatStr 格式化串
     * @return
     * @throws ParseException
     */
    public static String customFormatDateString(Object obj, String formatStr) throws ParseException {
        java.util.Date  date = objectFormatDate(obj);
        if (StringUtils.isBlank(formatStr)) {
            formatStr = DATATIME_FORMAT;
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    /**
     * 将Date换成Timestamp再转成字符
     * @param date 日期
     * @return
     */
    public static String dateToString(java.util.Date date){
        return longToDate(date.getTime()).toString();
    }

    /**
     * 将Long型转换为日期类型
     * @param lon
     * @return
     */
    public static java.util.Date longToDate(Long lon){
        Timestamp timestamp = new Timestamp(lon);
        return timestamp;
    }

    /**
     * 将Object对象转换成日期对象
     * @param obj obj对象
     * @return
     * @throws ParseException
     */
    public static java.util.Date objectFormatDate(Object obj) throws ParseException {
        java.util.Date date = null;
        if (obj instanceof String) {
            try {
                date = stringToDateTime(obj.toString());
            } catch (ParseException e) {
                date = stringToDate(obj.toString());
            }
        } else if (obj instanceof java.util.Date) {
            date = (java.util.Date) obj;
        } else if (obj instanceof Long) {
            date = new Timestamp(Long.valueOf(obj.toString()));
        }
        return date;
    }

    /**
     * 将Double转换成Integer
     * @param num double
     * @return
     */
    public static Integer doubleToInteger(double d) {
        return Integer.parseInt(new java.text.DecimalFormat("0").format(d));
    }


    /**
     * Double改变精度
     * @param d double
     * @param maxPrecision 最大精度
     * @return
     */
    public static Double doubleChangePrecision(Double d, Integer maxPrecision){
        if (maxPrecision == null) {
            return d;
        }
        NumberFormat nFormat = NumberFormat.getNumberInstance();
        //设置最大小数点后面位数
        nFormat.setMaximumFractionDigits(maxPrecision);
        //设置千分位格式
        nFormat.setGroupingUsed(false);
        return Double.valueOf( nFormat.format(d));
    }

}

