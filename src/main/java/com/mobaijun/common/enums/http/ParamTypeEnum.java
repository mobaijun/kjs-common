package com.mobaijun.common.enums.http;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: ParamTypeEnum
 * enum description：请求参数类型
 *
 * @author MoBaiJun 2022/5/12 13:27
 */
@Getter
public enum ParamTypeEnum {
    /**
     * query param参数
     */
    QUERY_PARAM(1),

    /**
     * body param参数，请求是json传来的
     */
    REQUEST_BODY(2);

    ParamTypeEnum(Integer code) {
        this.code = code;
    }

    private final Integer code;
}
