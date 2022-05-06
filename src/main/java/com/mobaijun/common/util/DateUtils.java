package com.mobaijun.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: DateUtils
 * 类描述： 日期工具类
 *
 * @author MoBaiJun 2022/4/22 18:51
 */
public class DateUtils {

    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
}
