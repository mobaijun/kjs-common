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
 * class name: UserConstant<br>
 * class description： 用户通用常量
 *
 * @author MoBaiJun 2022/5/12 9:15
 */
public final class UserConstant {

    /**
     * 系统默认的管理员密码
     */
    public static final String DEFAULT_PWD = "123456";

    /**
     * 管理员角色的名字
     */
    public static final String ADMIN_NAME = "管理员";

    /**
     * 管理员id
     */
    public static final Integer ADMIN_ID = 1;

    /**
     * 超级管理员角色id
     */
    public static final Integer ADMIN_ROLE_ID = 1;

    /**
     * 平台内系统用户的唯一标志
     */
    public static final String SYS_USER = "SYS_USER";

    /**
     * 正常状态
     */
    public static final String NORMAL = "0";

    /**
     * 异常状态
     */
    public static final String EXCEPTION = "1";

    /**
     * 用户封禁状态
     */
    public static final String USER_DISABLE = "1";

    /**
     * 角色封禁状态
     */
    public static final String ROLE_DISABLE = "1";

    /**
     * 部门正常状态
     */
    public static final String DEPT_NORMAL = "0";

    /**
     * 部门停用状态
     */
    public static final String DEPT_DISABLE = "1";

    /**
     * 字典正常状态
     */
    public static final String DICT_NORMAL = "0";

    /**
     * 是否为系统默认（是）
     */
    public static final String YES = "Y";

    /**
     * 用户名长度限制
     */
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * 登录名称是否唯一的返回结果码
     */
    public static final String USER_NAME_UNIQUE = "0";
    public static final String USER_NAME_NOT_UNIQUE = "1";

    /**
     * 手机号码是否唯一的返回结果
     */
    public static final String USER_PHONE_UNIQUE = "0";
    public static final String USER_PHONE_NOT_UNIQUE = "1";

    /**
     * e-mail 是否唯一的返回结果
     */
    public static final String USER_EMAIL_UNIQUE = "0";
    public static final String USER_EMAIL_NOT_UNIQUE = "1";

    /**
     * 部门名称是否唯一的返回结果码
     */
    public static final String DEPT_NAME_UNIQUE = "0";
    public static final String DEPT_NAME_NOT_UNIQUE = "1";

    /**
     * 角色名称是否唯一的返回结果码
     */
    public static final String ROLE_NAME_UNIQUE = "0";
    public static final String ROLE_NAME_NOT_UNIQUE = "1";

    /**
     * 岗位名称是否唯一的返回结果码
     */
    public static final String POST_NAME_UNIQUE = "0";
    public static final String POST_NAME_NOT_UNIQUE = "1";

    /**
     * 角色权限是否唯一的返回结果码
     */
    public static final String ROLE_KEY_UNIQUE = "0";
    public static final String ROLE_KEY_NOT_UNIQUE = "1";

    /**
     * 岗位编码是否唯一的返回结果码
     */
    public static final String POST_CODE_UNIQUE = "0";
    public static final String POST_CODE_NOT_UNIQUE = "1";

    /**
     * 菜单名称是否唯一的返回结果码
     */
    public static final String MENU_NAME_UNIQUE = "0";
    public static final String MENU_NAME_NOT_UNIQUE = "1";

    /**
     * 字典类型是否唯一的返回结果码
     */
    public static final String DICT_TYPE_UNIQUE = "0";
    public static final String DICT_TYPE_NOT_UNIQUE = "1";

    /**
     * 参数键名是否唯一的返回结果码
     */
    public static final String CONFIG_KEY_UNIQUE = "0";
    public static final String CONFIG_KEY_NOT_UNIQUE = "1";

    /**
     * 密码长度限制
     */
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 20;

    /**
     * 用户类型
     */
    public static final String SYSTEM_USER_TYPE = "00";
    public static final String REGISTER_USER_TYPE = "01";

    /**
     * 手机号码格式限制
     */
    public static final String MOBILE_PHONE_NUMBER_PATTERN = "^0{0,1}(13[0-9]|15[0-9]|14[0-9]|18[0-9])[0-9]{8}$";
}