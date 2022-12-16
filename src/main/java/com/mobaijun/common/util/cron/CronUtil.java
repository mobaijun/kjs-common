/*
 * Copyright (C) 2022 www.mobaijun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.util.cron;

import com.mobaijun.common.constant.NumberConstant;
import com.mobaijun.common.util.PrintUtil;

import java.util.Objects;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: CronUtils<br>
 * class description： Cron 表达式工具类
 *
 * @author MoBaiJun 2022/8/8 17:04
 */
public class CronUtil {

    /**
     * 方法摘要：构建Cron表达式
     *
     * @param taskScheduleModel 任务调度模型
     * @return String cron 表达式
     */
    public static String createCronExpression(TaskScheduleModel taskScheduleModel) {
        StringBuilder cronExp = new StringBuilder();
        Objects.requireNonNull(taskScheduleModel.getJobType(), "Execution period is not configured");
        if (null != taskScheduleModel.getSecond()
                && null != taskScheduleModel.getMinute()
                && null != taskScheduleModel.getHour()) {
            // 秒
            cronExp.append(taskScheduleModel.getSecond()).append(" ");
            // 分
            cronExp.append(taskScheduleModel.getMinute()).append(" ");
            // 小时
            cronExp.append(taskScheduleModel.getHour()).append(" ");
            // 每天
            if (taskScheduleModel.getJobType() == 1) {
                if (taskScheduleModel.getBeApart() != null) {
                    // 日
                    cronExp.append("1");
                    cronExp.append("/");
                    // 月
                    cronExp.append(taskScheduleModel.getBeApart() + 1);
                    cronExp.append(" ");
                    cronExp.append("* ");
                    // 周
                    cronExp.append("? ");
                    cronExp.append("*");
                } else {
                    // 日
                    cronExp.append("* ");
                    // 月
                    cronExp.append("* ");
                    // 周
                    cronExp.append("?");
                }
            }

            // 按每周
            else if (taskScheduleModel.getJobType() == NumberConstant.THREE) {
                // 一个月中第几天
                cronExp.append("? ");
                // 月份
                cronExp.append("* ");
                // 周
                Integer[] weeks = taskScheduleModel.getDayOfWeeks();
                for (int i = 0; i < weeks.length; i++) {
                    if (i == 0) {
                        cronExp.append(weeks[i]);
                    } else {
                        cronExp.append(",").append(weeks[i]);
                    }
                }

            }

            // 按每月
            else if (taskScheduleModel.getJobType() == 2) {
                // 一个月中的哪几天
                Integer[] days = taskScheduleModel.getDayOfMonths();
                for (int i = 0; i < days.length; i++) {
                    if (i == 0) {
                        if (days[i] == 32) {
                            // 本月最后一天
                            return "0 0 0 L * ?";
                        } else {
                            cronExp.append(days[i]);
                        }
                    } else {
                        cronExp.append(",").append(days[i]);
                    }
                }
                // 月份
                cronExp.append(" * ");
                // 周
                cronExp.append("?");
            } else if (taskScheduleModel.getJobType() == 0) {
                // 日
                cronExp.append("* ");
                // 月
                cronExp.append("* ");
                // 周
                cronExp.append("?");
            }
        } else {
            PrintUtil.println("时或分或秒参数未配置");
        }
        return cronExp.toString();
    }

    /**
     * 方法摘要：生成计划的详细描述
     *
     * @param taskScheduleModel 任务调度模型
     * @return String 表达式
     */
    public static String createDescription(TaskScheduleModel taskScheduleModel) {
        StringBuilder description = new StringBuilder();
        if (null != taskScheduleModel.getSecond()
                && null != taskScheduleModel.getMinute()
                && null != taskScheduleModel.getHour()) {
            // 按每天
            if (taskScheduleModel.getJobType() == 1) {
                description.append("每天");
                description.append(taskScheduleModel.getHour()).append("时");
                description.append(taskScheduleModel.getMinute()).append("分");
                description.append(taskScheduleModel.getSecond()).append("秒");
                description.append("执行");
            }

            // 按每周
            else if (taskScheduleModel.getJobType() == 3) {
                if (taskScheduleModel.getDayOfWeeks() != null && taskScheduleModel.getDayOfWeeks().length > 0) {
                    StringBuilder days = new StringBuilder();
                    for (int i : taskScheduleModel.getDayOfWeeks()) {
                        days.append("周").append(i);
                    }
                    description.append("每周的").append(days).append(" ");
                }
                if (null != taskScheduleModel.getSecond()
                        && null != taskScheduleModel.getMinute()
                        && null != taskScheduleModel.getHour()) {
                    description.append(",");
                    description.append(taskScheduleModel.getHour()).append("时");
                    description.append(taskScheduleModel.getMinute()).append("分");
                    description.append(taskScheduleModel.getSecond()).append("秒");
                }
                description.append("执行");
            }

            // 按每月
            else if (taskScheduleModel.getJobType() == 2) {
                // 选择月份
                if (taskScheduleModel.getDayOfMonths() != null && taskScheduleModel.getDayOfMonths().length > 0) {
                    StringBuilder days = new StringBuilder();
                    for (int i : taskScheduleModel.getDayOfMonths()) {
                        days.append(i).append("号");
                    }
                    description.append("每月的").append(days).append(" ");
                }
                description.append(taskScheduleModel.getHour()).append("时");
                description.append(taskScheduleModel.getMinute()).append("分");
                description.append(taskScheduleModel.getSecond()).append("秒");
                description.append("执行");
            }

        }
        return description.toString();
    }

    /**
     * 构建Cron表达式
     *
     * @param rate  执行单位
     * @param cycle 循环周期
     * @return cron 表达式
     */
    public static String createLoopCronExpression(int rate, int cycle) {
        String cron;
        switch (rate) {
            // 每cycle秒执行一次
            case 0:
                cron = "0/" + cycle + " * * * * ?";
                break;
            // 每cycle分钟执行一次
            case 1:
                cron = "0 0/" + cycle + " * * * ?";
                break;
            // 每cycle小时执行一次
            case 2:
                cron = "0 0 0/" + cycle + " * * ?";
                break;
            // 每cycle天的0点执行一次
            case 3:
                cron = "0 0 0 1/" + cycle + " * ?";
                break;
            // 每cycle月的1号0点执行一次
            case 4:
                cron = "0 0 0 1 1/" + cycle + " ? ";
                break;
            //  每天cycle点执行一次
            case 5:
                cron = "0 0 " + cycle + "  * * ?";
                break;
            default:
                // 默认每cycle秒执行一次
                cron = "0/1 * * * * ?";
                break;
        }
        return cron;
    }
}