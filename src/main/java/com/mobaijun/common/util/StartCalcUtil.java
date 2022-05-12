package com.mobaijun.common.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: StartCalcUtil
 * class description：开始时间的计时工具
 *
 * @author MoBaiJun 2022/5/12 14:05
 */
public class StartCalcUtil {
    /**
     * 项目开始启动时间
     */
    public static Date startDate = null;

    /**
     * 初始化项目开始时间
     *
     * @param date 开始日期
     */
    public static void init(Date date) {
        startDate = date;
    }

    /**
     * 计算是否项目已经启动
     *
     * @param date                 日期
     * @param startInterValSeconds 启动时间毫秒值
     * @return true启动 false 未启动
     */
    public static boolean calcEnable(Date date, long startInterValSeconds) {
        return DateUtil.between(startDate, date, DateUnit.SECOND) > startInterValSeconds;
    }
}
