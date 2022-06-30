package com.mobaijun.common.result;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: ResultCode
 * interface description： 获取业务码
 * 接口描述： 获取业务码
 *
 * @author MoBaiJun 2022/6/30 15:02
 */
public interface ResultCode {
    /**
     * 获取业务码
     *
     * @return 业务码
     */
    Integer getCode();

    /**
     * 获取信息
     *
     * @return 返回结构体中的信息
     */
    String getMessage();
}
