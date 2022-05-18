package com.mobaijun.common.enums.file;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: FileLocationEnum
 * enum description：文件存储位置
 *
 * @author MoBaiJun 2022/5/12 13:18
 */
@Getter
public enum FileLocationEnum {

    /**
     * 阿里云
     */
    ALIYUN(1),

    /**
     * 腾讯云
     */
    TENCENT(2),

    /**
     * minio服务器
     */
    MINIO(3),

    /**
     * 本地
     */
    LOCAL(4),

    /**
     * 数据库中
     */
    DB(5);

    private final Integer code;

    FileLocationEnum(int code) {
        this.code = code;
    }
}
