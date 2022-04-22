package com.mobaijun.common.result.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * EnumName: BaseResultCode
 * 枚举描述： 返回状态码
 *
 * @Author MoBaiJun 2022/4/22 17:30
 */
@Getter
@AllArgsConstructor
public enum HttpStatus {

    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 服务器内部异常
     */
    ERROR(500, "Internal Server Error"),

    /**
     * 数据库保存/更新异常
     */
    UPDATE_DATABASE_ERROR(90001, "Update Database Error"),

    /**
     * 通用的逻辑校验异常
     */
    LOGIC_CHECK_ERROR(90004, "Logic Check Error"),

    /**
     * 恶意请求
     */
    MALICIOUS_REQUEST(90005, "Malicious Request"),

    /**
     * 文件上传异常
     */
    FILE_UPLOAD_ERROR(90006, "File Upload Error"),

    /**
     * 重复执行
     */
    REPEATED_EXECUTE(90007, "Repeated execute"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(99999, "Unknown Error");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 消息
     */
    private final String message;
}
