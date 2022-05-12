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
     * 错误码
     */
    private Integer errorCode;

    /**
     * 返回给用户的提示信息
     */
    private String userTip;

    /**
     * 异常的模块名称
     */
    private String moduleName;

    /**
     * 异常的具体携带数据
     */
    private Object data;

    BaseException(Integer errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

    BaseException(Throwable cause, Integer errorCode, String userTip) {
        super(cause);
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

    /**
     * 根据模块名，错误码，用户提示直接抛出异常
     *
     * @param moduleName 模块名
     * @param errorCode  状态码
     * @param userTip    消息
     */
    BaseException(String moduleName, Integer errorCode, String userTip) {
        super(userTip);
        this.errorCode = errorCode;
        this.moduleName = moduleName;
        this.userTip = userTip;
    }

    /**
     * 如果要直接抛出ServiceException，可以用这个构造函数
     *
     * @param moduleName 模块名
     * @param exception  异常信息
     */
    BaseException(String moduleName, AbstractExceptionEnum exception) {
        super(exception.getUserTip());
        this.moduleName = moduleName;
        this.errorCode = exception.getErrorCode();
        this.userTip = exception.getUserTip();
    }


    /**
     * 不建议直接抛出ServiceException，因为这样无法确认是哪个模块抛出的异常，建议使用业务异常时，都抛出自己模块的异常类
     *
     * @param moduleName 模块名称
     * @param exception  异常信息
     */
    BaseException(AbstractExceptionEnum exception, String moduleName) {
        super(exception.getUserTip());
        this.moduleName = moduleName;
        this.errorCode = exception.getErrorCode();
        this.userTip = exception.getUserTip();
    }

    /**
     * 携带数据的异常构造函数
     *
     * @param moduleName 模块名称
     * @param errorCode  状态码
     * @param userTip    描述
     * @param data       返回信息
     */
    BaseException(String moduleName, Integer errorCode, String userTip, Object data) {
        super(userTip);
        this.errorCode = errorCode;
        this.moduleName = moduleName;
        this.userTip = userTip;
        this.data = data;
    }
}
