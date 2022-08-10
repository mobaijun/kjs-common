package com.mobaijun.common.util.cron;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: TaskScheduleModel
 * class description： cron 表达式参数实体
 *
 * @author MoBaiJun 2022/8/8 17:06
 */
@Getter
@Setter
@ToString
public class TaskScheduleModel {

    /**
     * 所选作业类型:
     * 0  ->  每次
     * 1  ->  每天
     * 2  ->  每月
     * 3  ->  每周
     * 4  ->  间隔（每隔2个小时，每隔30分钟）
     */
    Integer jobType;

    /**
     * 一周的哪几天
     */
    Integer[] dayOfWeeks;

    /**
     * 一个月的哪几天
     */
    Integer[] dayOfMonths;

    /**
     * 秒
     */
    Integer second;

    /**
     * 分
     */
    Integer minute;

    /**
     * 时
     */
    Integer hour;

    /**
     * 间隔时间
     */
    Integer beApart;
}
