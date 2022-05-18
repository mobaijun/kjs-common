package com.mobaijun.common.result;

import com.mobaijun.common.result.enums.HttpStatus;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: R
 * class description： 返回
 *
 * @author MoBaiJun 2022/5/17 10:56
 */
public class R<T> {

    /**
     * 返回状态
     */
    private boolean flag;

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public static <T> R<T> ok() {
        return restR(true, null, HttpStatus.OK.getCode(), HttpStatus.OK.getMessage());
    }

    public static <T> R<T> ok(T data) {
        return restR(true, data, HttpStatus.OK.getCode(), HttpStatus.OK.getMessage());
    }

    public static <T> R<T> ok(T data, String message) {
        return restR(true, data, HttpStatus.OK.getCode(), message);
    }

    public static <T> R<T> fail() {
        return restR(false, null, HttpStatus.ERROR.getCode(), HttpStatus.ERROR.getMessage());
    }

    public static <T> R<T> fail(HttpStatus httpStatus) {
        return restR(false, null, httpStatus.getCode(), httpStatus.getMessage());
    }

    public static <T> R<T> fail(String message) {
        return restR(false, message);
    }

    public static <T> R<T> fail(T data) {
        return restR(false, data, HttpStatus.ERROR.getCode(), HttpStatus.ERROR.getMessage());
    }

    public static <T> R<T> fail(T data, String message) {
        return restR(false, data, HttpStatus.ERROR.getCode(), message);
    }

    public static <T> R<T> fail(int code, String message) {
        return restR(false, null, code, message);
    }

    private static <T> R<T> restR(boolean flag, String message) {
        R<T> apiR = new R<>();
        apiR.setFlag(flag);
        apiR.setCode(flag ? HttpStatus.OK.getCode() : HttpStatus.ERROR.getCode());
        apiR.setMessage(message);
        return apiR;
    }

    private static <T> R<T> restR(Boolean flag, T data, int code, String message) {
        R<T> apiR = new R<>();
        apiR.setFlag(flag);
        apiR.setData(data);
        apiR.setCode(code);
        apiR.setMessage(message);
        return apiR;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
