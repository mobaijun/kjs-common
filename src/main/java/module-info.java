/**
 * Description: kjs.common 模块，提供通用功能的集合
 * Author: mobaijun
 * Date: 2024/10/9 10:41
 * IntelliJ IDEA Version: 2023.1.4
 */
module kjs.common {
    // 导出公共功能包
    exports com.mobaijun.common;

    // 导出断言相关包
    exports com.mobaijun.common.assertions;

    // 导出集合相关包
    exports com.mobaijun.common.collection;

    // 导出并发工具包
    exports com.mobaijun.common.concurrent;

    // 导出常量定义包
    exports com.mobaijun.common.constant;

    // 导出日期处理包
    exports com.mobaijun.common.date;

    // 导出枚举定义包
    exports com.mobaijun.common.enums;

    // 导出缓存相关枚举
    exports com.mobaijun.common.enums.cache;

    // 导出客户端相关枚举
    exports com.mobaijun.common.enums.client;

    // 导出通用枚举
    exports com.mobaijun.common.enums.comm;

    // 导出数据源相关枚举
    exports com.mobaijun.common.enums.datasource;

    // 导出日期相关枚举
    exports com.mobaijun.common.enums.date;

    // 导出设备相关枚举
    exports com.mobaijun.common.enums.device;

    // 导出文件相关枚举
    exports com.mobaijun.common.enums.file;

    // 导出HTTP相关枚举
    exports com.mobaijun.common.enums.http;

    // 导出任务相关枚举
    exports com.mobaijun.common.enums.job;

    // 导出锁相关枚举
    exports com.mobaijun.common.enums.lock;

    // 导出Redis相关枚举
    exports com.mobaijun.common.enums.redis;

    // 导出正则表达式相关枚举
    exports com.mobaijun.common.enums.regex;

    // 导出系统相关枚举
    exports com.mobaijun.common.enums.sys;

    // 导出系统字典相关枚举
    exports com.mobaijun.common.enums.sys.dict;

    // 导出系统日志相关枚举
    exports com.mobaijun.common.enums.sys.log;

    // 导出系统消息相关枚举
    exports com.mobaijun.common.enums.sys.message;

    // 导出系统短信相关枚举
    exports com.mobaijun.common.enums.sys.sms;

    // 导出验证相关枚举
    exports com.mobaijun.common.enums.verification;

    // 导出文件处理包
    exports com.mobaijun.common.file;

    // 导出函数接口包
    exports com.mobaijun.common.function;

    // 导出函数实现包
    exports com.mobaijun.common.function.impl;

    // 导出Google相关功能包
    exports com.mobaijun.common.google;

    // 导出GPS相关功能包
    exports com.mobaijun.common.gps;

    // 导出HTTP客户端包
    exports com.mobaijun.common.http;

    // 导出JDBC相关功能包
    exports com.mobaijun.common.jdbc;

    // 导出JDK工具包
    exports com.mobaijun.common.jdk;

    // 导出Lambda表达式包
    exports com.mobaijun.common.lambda;

    // 导出许可证处理包
    exports com.mobaijun.common.license;

    // 导出迷你表格处理包
    exports com.mobaijun.common.minitable;

    // 导出模型定义包
    exports com.mobaijun.common.model;

    // 导出网络相关功能包
    exports com.mobaijun.common.network;

    // 导出数字处理包
    exports com.mobaijun.common.number;

    // 导出拼音处理包
    exports com.mobaijun.common.pinyin;

    // 导出返回结果处理包
    exports com.mobaijun.common.result;

    // 导出SQL处理包
    exports com.mobaijun.common.sql;

    // 导出系统工具包
    exports com.mobaijun.common.system;

    // 导出文本处理包
    exports com.mobaijun.common.text;

    // 导出线程处理包
    exports com.mobaijun.common.thread;

    // 导出时间处理包
    exports com.mobaijun.common.time;

    // 导出工具类包
    exports com.mobaijun.common.tool;

    // 导出树结构处理包
    exports com.mobaijun.common.tree;

    // 声明依赖的模块
    requires java.base;
    requires java.desktop;
    requires jdk.management;
    requires java.logging;
    requires java.net.http;
    requires java.sql;
    requires lombok;
    requires org.slf4j;
    // Swagger 3.x 支持
    requires io.swagger.v3.oas.annotations;
}