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