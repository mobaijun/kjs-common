package com.mobaijun.common.exception;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: CustomException
 * 类描述： 自定义异常信息
 *
 * @author MoBaiJun 2022/4/22 16:57
 */
public class CustomException extends BaseException {

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private final String message;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(int code, String message) {
        this.message = message;
        this.code = code;
    }
}
