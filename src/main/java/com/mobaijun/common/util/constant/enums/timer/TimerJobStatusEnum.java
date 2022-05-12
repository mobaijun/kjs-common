package com.mobaijun.common.util.constant.enums.timer;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: TimerJobStatusEnum
 * enum description： 定时任务状态
 *
 * @author MoBaiJun 2022/5/12 13:43
 */
@Getter
public enum TimerJobStatusEnum {
    /**
     * 启动状态
     */
    RUNNING(1),

    /**
     * 停止状态
     */
    STOP(2);

    private final Integer code;

    TimerJobStatusEnum(int code) {
        this.code = code;
    }
}
