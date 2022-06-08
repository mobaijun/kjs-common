package com.mobaijun.common.base.entity;

import com.mobaijun.common.util.ObjectUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: BaseEntity
 * class description： 分页基类
 *
 * @author MoBaiJun 2022/6/8 9:05
 */
@Getter
@Setter
@Accessors(chain = true)
public abstract class BaseEntity<E> implements Serializable {

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 页大小
     */
    private int pageSize;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * 参数
     */
    private E param;

    public int pageNum() {
        if (ObjectUtils.isEmpty(pageNum)) {
            pageNum = 1;
        }
        return pageNum;
    }

    public int getPageSize() {
        if (ObjectUtils.isEmpty(pageSize)) {
            // 默认 20 条
            pageSize = 20;
        }
        return pageSize;
    }
}
