package com.mobaijun.common.util.constant.enums.log;

import lombok.Getter;

/**
 * software：IntelliJ IDEA 2022.1
 * enum name: BusinessType
 * enum description： 业务操作类型
 *
 * @author MoBaiJun 2022/5/12 9:18
 */
@Getter
public enum BusinessType {

    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,

    /**
     * 清空
     */
    CLEAN,
}
