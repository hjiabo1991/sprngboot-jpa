package com.hjb.jpa.tools;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间帮助工具
 */
public class TimeUtils {

    /**
     * 获取当前秒
     * @return
     */
    public static long getCurrentSeconds() {
        long milliSeconds = System.currentTimeMillis();
        return milliSeconds / 1000;
    }
    /**
     * 获取当前秒
     * @return
     */
    public static String getCurrentSecondMill() {
        long milliSeconds = System.currentTimeMillis();
        return String.valueOf(milliSeconds / 1000);
    }

    /**
     * 将字符串转为timestamp
     * @param date 时间字符串
     * @param pattern from pattern
     * @return StringValue
     */
    public static String transDate(Date date, String pattern) {
        SimpleDateFormat sdfFrom = new SimpleDateFormat(pattern);
        String time = null;
        try {
            time = sdfFrom.format(date);
        } catch (Exception e) {
            System.err.println("时间转换失败");
        }
        return time;
    }
}
