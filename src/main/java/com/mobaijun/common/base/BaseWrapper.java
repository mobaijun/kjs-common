package com.mobaijun.common.base;

import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: BaseWrapper
 * class description：控制器查询结果的包装类基类（此处使用的是模板方法模式）
 *
 * @author MoBaiJun 2022/5/11 14:35
 */
public abstract class BaseWrapper {

    public Object obj;

    public BaseWrapper(Object obj) {
        this.obj = obj;
    }

    /**
     * 包装器
     *
     * @return 对象
     */
    @SuppressWarnings("unchecked")
    public <T> T warp() {
        if (this.obj instanceof List) {
            List<Object> list = (List<Object>) this.obj;
            for (Object o : list) {
                if (o instanceof Map) {
                    warpTheMap((Map<String, Object>) o);
                } else {
                    warpTheObject(o);
                }
            }
            return (T) list;
        } else if (this.obj instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) this.obj;
            warpTheMap(map);
            return (T) map;
        } else {
            warpTheObject(this.obj);
            return (T) this.obj;
        }
    }

    /**
     * map 包装器
     *
     * @param map map
     */
    protected abstract void warpTheMap(Map<String, Object> map);

    protected void warpTheObject(Object o) {
    }

}
