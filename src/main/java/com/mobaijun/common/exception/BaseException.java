package com.mobaijun.common.exception;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BaseException
 * 类描述： 自定义基础异常
 *
 * @author MoBaiJun 2022/4/25 15:11
 */
public class BaseException extends RuntimeException {

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;
}
