package com.mobaijun.common.util.tool;

import cn.hutool.log.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: MapBeanUtil
 * 类描述： 实体对象转map
 *
 * @author MoBaiJun 2022/4/24 10:53
 */
public class MapBeanUtils {

    /**
     * tools log
     */
    private static final Log log = Log.get(MapBeanUtils.class);

    /**
     * 实体对象转成Map
     *
     * @param obj 对象
     * @return Map String, Object
     */
    public static Map<String, Object> objectTwoMap(Object obj) {
        Map<String, Object> map = new HashMap<>(1000);
        if (obj == null) {
            return map;
        }
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            log.error(e, e.getMessage());
        }
        return map;
    }

    /**
     * Map转成实体对象
     *
     * @param map   实体对象包含属性
     * @param clazz 实体对象类型
     * @return Object
     */
    public static Object mapTwoObject(Map<String, Object> map, Class<?> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            log.error(e, e.getMessage());
        }
        return obj;
    }
}
