package com.mobaijun.common.result;

import com.mobaijun.common.result.enums.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: R
 * class description：返回体结构
 *
 * @author MoBaiJun 2022/6/30 15:01
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static <T> R<T> ok() {
        return ok(null);
    }

    public static <T> R<T> ok(T data) {
        return new R<T>().setCode(HttpStatus.OK.getCode()).setData(data)
                .setMessage(HttpStatus.OK.getMessage());
    }

    public static <T> R<T> ok(T data, String message) {
        return new R<T>().setCode(HttpStatus.OK.getCode()).setData(data).setMessage(message);
    }

    public static <T> R<T> failed(int code, String message) {
        return new R<T>().setCode(code).setMessage(message);
    }

    public static <T> R<T> failed(HttpStatus failMsg) {
        return new R<T>().setCode(failMsg.getCode()).setMessage(failMsg.getMessage());
    }

    public static <T> R<T> failed(HttpStatus failMsg, String message) {
        return new R<T>().setCode(failMsg.getCode()).setMessage(message);
    }
}
