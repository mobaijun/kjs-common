package com.mobaijun.common.exception;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: CustomException
 * 类描述： 自定义异常信息
 *
 * @author MoBaiJun 2022/4/22 16:57
 */
public class CustomException extends BaseException {

    public CustomException(Integer errorCode, String userTip) {
        super(errorCode, userTip);
    }
}
