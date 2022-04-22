package com.mobaijun.common.result;

import com.mobaijun.common.result.enums.HttpStatus;
import com.mobaijun.common.util.ObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: ErrorTip
 * 类描述： 异常提示
 *
 * @Author MoBaiJun 2022/4/22 17:24
 */
@Getter
@Setter
public class ErrorTip<T> extends AbstractTip<T> implements Serializable {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 判断数据是否异常
     *
     * @param data 数据
     */
    public ErrorTip(T data) {
        super();
        if (ObjectUtils.isEmpty(data)) {
            super.code = HttpStatus.ERROR.getCode();
            super.message = HttpStatus.ERROR.getMessage();
        }
    }

    /**
     * 返回状态码和消息
     *
     * @param code    状态码
     * @param message 消息
     */
    public ErrorTip(int code, String message) {
        super();
        super.code = code;
        super.message = message;
    }

    /**
     * 返回异常信息和状态码
     *
     * @param code    状态码
     * @param message 异常信息
     * @param data    消息体
     */
    public ErrorTip(int code, String message, T data) {
        super();
        if (ObjectUtils.isEmpty(data)) {
            super.code = code;
            super.message = message;
            this.data = data;
        }
    }

    /**
     * 返回异常信息
     *
     * @param message 异常信息
     */
    public ErrorTip(String message) {
        super();
        super.message = message;
    }
}
