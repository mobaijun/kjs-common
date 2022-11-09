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
package com.mobaijun.common.common;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: DefaultValues
 * class description： 常用默认值
 *
 * @author MoBaiJun 2022/5/31 11:30
 */
public class DefaultValues {

    /**
     * 默认分页条数
     */
    public static final int PAGE_SIZE = 10;

    /**
     * 默认分页最大条数
     */
    public static final int MAX_PAGE_SIZE = 50;

    /**
     * 默认缓存时间 30分钟
     */
    public static final int CACHE_TIME = 30 * 60 * 1000;

    /**
     * 默认的父级节点id
     */
    public static final String ROOT_NODE_ID = "root";

    /**
     * 默认的路径分隔符
     */
    public static final String DEFAULT_PATH_DELIMITER = "/";


    public static class Datasource {
        /**
         * 初始化连接(最小连接数)
         */
        public static final int MIN_ACTION_NUM = 1;

        /**
         * 最大连接数
         */
        public static final int DEFAULT_DATASOURCE_MAX_ACTION_NUM = 10;

        /**
         * 最大等待时间
         */
        public static final int DEFAULT_DATASOURCE_MAX_WAIT_TIME = 15000;

        /**
         * 最小空闲时间
         */
        public static final int DEFAULT_DATASOURCE_MIN_EVICTABLE_IDLE_TIME = 30000;

        /**
         * 最大空闲时间
         */
        public static final int MAX_EVICTABLE_IDLE_TIME = 30000;
    }

    public static class Date {

        /**
         * 默认时间格式化(年月日，时分秒)
         */
        public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

        /**
         * 默认时间格式化(年月日，时分)
         */
        public static final String DATE_TIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

        /**
         * 默认时间格式化(年月日)
         */
        public static final String DATE_PATTERN = "yyyy-MM-dd";
    }

    public static class Thread {

        /**
         * 要保留的空闲线程数。
         */
        public static final int CORE_POOL_SIZE = 0;

        /**
         * 最大线程池数量(获取系统处理器个数，作为线程池数量)
         * public static final
         */
        public static final int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

        /**
         * 定时线程池处理线程数
         */
        public static final int SCHEDULED_EXECUTOR_POOL_SIZE = 8;
    }

    public static class Author {
        /**
         * 默认邮箱
         */
        public static final String EMAIL = "mobaijun8@163.com";

        /**
         * 默认 gmail 邮箱
         */
        public static final String EMAIL_GMAIL = "wljmobai@gmail.com";

        /**
         * 默认名称
         */
        public static final String NAME = "MoBaiJun";

        /**
         * 默认名字
         */
        public static final String FIRST_NAME = "墨白";

        /**
         * 默认主页
         */
        public static final String URL = "https://www.mobaijun.com";

        /**
         * 品牌
         */
        public static final String BRAND = "框架师";
    }
}