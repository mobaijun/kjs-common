package com.mobaijun.common.util.base;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * interface name: BaseWrapper
 * interface description：基础包装接口
 *
 * @author MoBaiJun 2022/5/12 14:02
 */
public interface BaseWrapper<T> {

    /**
     * 具体包装的过程
     *
     * @param beWrappedModel 被包装的原始对象，可以是obj，list，page，PageResult
     * @return 包装后增加的增量集合
     */
    Map<String, Object> doWrap(T beWrappedModel);
}
