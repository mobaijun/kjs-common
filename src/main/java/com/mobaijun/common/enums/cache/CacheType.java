package com.mobaijun.common.enums.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [缓存枚举]
 * Author: [mobaijun]
 * Date: [2024/8/12 14:54]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum CacheType {

    /**
     * 全局 redis key (业务无关的key)
     */
    GLOBAL_REDIS_KEY("global:"),

    /**
     * 验证码 redis key
     */
    CAPTCHA_CODE_KEY(GLOBAL_REDIS_KEY + "captcha_codes:"),

    /**
     * 防重提交 redis key
     */
    REPEAT_SUBMIT_KEY(GLOBAL_REDIS_KEY + "repeat_submit:"),

    /**
     * 限流 redis key
     */
    RATE_LIMIT_KEY(GLOBAL_REDIS_KEY + "rate_limit:"),

    /**
     * 登录账户密码错误次数 redis key
     */
    PWD_ERR_CNT_KEY(GLOBAL_REDIS_KEY + "pwd_err_cnt:"),

    /**
     * 三方认证 redis key
     */
    SOCIAL_AUTH_CODE_KEY(GLOBAL_REDIS_KEY + "social_auth_codes:"),

    /**
     * 在线用户 redis key
     */
    ONLINE_TOKEN_KEY("online_tokens:"),

    /**
     * 参数管理 cache key
     */
    SYS_CONFIG_KEY("sys_config:"),

    /**
     * 字典管理 cache key
     */
    SYS_DICT_KEY("sys_dict:");

    /**
     * 缓存值
     */
    private final String value;
}
