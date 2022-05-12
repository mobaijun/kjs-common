package com.mobaijun.common.exception;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: AbstractExceptionEnum
 * interface description：
 * 接口描述：
 *
 * @author MoBaiJun 2022/5/12 11:24
 */
public interface AbstractExceptionEnum {

    /**
     * 获取异常的状态码
     *
     * @return String
     */
    Integer getErrorCode();

    /**
     * 获取给用户提示信息
     *
     * @return String
     */
    String getUserTip();
}
