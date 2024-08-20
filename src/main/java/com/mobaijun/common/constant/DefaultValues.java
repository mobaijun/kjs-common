/*
 * Copyright (C) 2022 [www.mobaijun.com]
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
package com.mobaijun.common.constant;

/**
 * software：IntelliJ IDEA 2022.1<br>
 * class name: DefaultValues<br>
 * class description： 常用默认值
 *
 * @author MoBaiJun 2022/5/31 11:30
 */
public final class DefaultValues {

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
         * 默认博客地址
         */
        public static final String BLOG_URL = "https://www.mobaijun.com/";

        /**
         * 默认文档地址
         */
        public static final String DOCS_URL = "https://docs.mobaijun.com/";

        /**
         * 默认 api
         */
        public static final String URL = "https://api.mobaijun.com/";

        /**
         * 默认导航地址
         */
        public static final String NAV_URL = "https://nav.mobaijun.com/";

        /**
         * 默认 GitHub 主页
         */
        public static final String GitHub_HOME = "https://github.com/mobaijun";

        /**
         * 默认组织 GitHub 主页
         */
        public static final String GITHUB_ORGANIZATIONS = "https://github.com/april-projects";

        /**
         * 默认 gitee 主页
         */
        public static final String GITEE_HOME = "https://gitee.com/mobaijun";

        /**
         * 品牌
         */
        public static final String BRAND = "框架师";
    }
}