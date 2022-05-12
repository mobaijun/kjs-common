package com.mobaijun.common.util.constant.enums.file;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: FileStatusEnum
 * enum description：文件状态
 *
 * @author MoBaiJun 2022/5/12 13:19
 */
@Getter
public enum FileStatusEnum {
    /**
     * 新文件
     * <p>
     * 如果code相同，每次版本号替换都会把当前文件设置成最新文件
     */
    NEW("1"),

    /**
     * 旧文件
     */
    OLD("0");

    private final String code;

    FileStatusEnum(String code) {
        this.code = code;
    }
}
