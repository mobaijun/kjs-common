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
package com.mobaijun.common.constant;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ShiroConstants
 * class description：Shiro通用常量
 *
 * @author MoBaiJun 2022/5/12 9:16
 */
public class ShiroConstants {

    /**
     * 当前登录的用户
     */
    public static final String CURRENT_USER = "currentUser";

    /**
     * 用户名
     */
    public static final String CURRENT_USERNAME = "username";

    /**
     * 消息key
     */
    public static final String MESSAGE = "message";

    /**
     * 错误key
     */
    public static final String ERROR = "errorMsg";

    /**
     * 编码格式
     */
    public static final String ENCODING = "UTF-8";

    /**
     * 当前在线会话
     */
    public static final String ONLINE_SESSION = "online_session";

    /**
     * 验证码key
     */
    public static final String CURRENT_CAPTCHA = "captcha";

    /**
     * 验证码开关
     */
    public static final String CURRENT_ENABLED = "captchaEnabled";

    /**
     * 验证码类型
     */
    public static final String CURRENT_TYPE = "captchaType";

    /**
     * 验证码错误
     */
    public static final String CAPTCHA_ERROR = "captchaError";

    /**
     * 登录记录缓存
     */
    public static final String LOGIN_RECORD_CACHE = "loginRecordCache";

    /**
     * 系统活跃用户缓存
     */
    public static final String SYS_USER_CACHE = "sys-userCache";
}