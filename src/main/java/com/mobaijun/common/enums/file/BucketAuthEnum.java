package com.mobaijun.common.enums.file;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: BucketAuthEnum
 * enum description：桶的权限策略枚举
 *
 * @author MoBaiJun 2022/5/12 13:18
 */
public enum BucketAuthEnum {
    /**
     * 私有的（仅有 owner 可以读写）
     */
    PRIVATE,

    /**
     * 公有读，私有写（ owner 可以读写， 其他客户可以读）
     */
    PUBLIC_READ,

    /**
     * 公共读写（即所有人都可以读写，慎用）
     */
    PUBLIC_READ_WRITE,

    /**
     * 只写 （其他客户端只有写入文件权限，无读取文件权限）
     * <p>
     * 即公有写，私有读（ owner 可以读写， 其他客户可以写）
     */
    MINIO_WRITE_ONLY,
}
