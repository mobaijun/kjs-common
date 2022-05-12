package com.mobaijun.common.exception;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ToolBoxException
 * class description： 工具类初始化异常
 *
 * @author MoBaiJun 2022/5/12 10:10
 */
public class ToolBoxException extends BaseException {

    public ToolBoxException(Integer errorCode, String userTip) {
        super(errorCode, userTip);
    }
}
