/*
 * Copyright (C) 2022 www.mobaijun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.common.enhance;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.mobaijun.common.util.collection.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: EnhanceAnnotationUtils<br>
 * class description: 增强注解工具类
 *
 * @author MoBaiJun 2022/11/23 21:04
 */
@SuppressWarnings("all")
public class EnhanceAnnotationUtils extends AnnotationUtil {

    /**
     * 设置注解的某个字段的值
     *
     * @param annotation 注解
     * @param fieldName  字段
     * @param fieldValue 新的字段值
     * @param <T>        T
     * @return Annotation
     */
    public static <T extends Annotation> T setAnnotationFieldValue(T annotation, String fieldName, Object fieldValue) {
        if (ObjectUtil.isAllNotEmpty(annotation, fieldName)) {
            Map annotationFieldValueMap = (Map) ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(annotation, "h"), "memberValues");
            if (annotationFieldValueMap.containsKey(fieldName)) {
                annotationFieldValueMap.put(fieldName, fieldValue);
            }
        }
        return annotation;
    }

    /**
     * 获取注解的某个字段值
     *
     * @param annotation 注解
     * @param fieldName  字段名
     * @param <T>        T
     * @return Annotation
     */
    public static <T extends Annotation> Object getAnnotationFieldValue(T annotation, String fieldName) {
        Object result = null;
        if (ObjectUtil.isAllNotEmpty(annotation, fieldName)) {
            Map annotationFieldValueMap = (Map) ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(annotation, "h"), "memberValues");
            result = annotationFieldValueMap.get(fieldName);
        }
        return result;
    }

    /**
     * 复制注解的字段值
     *
     * @param annotation      目标注解
     * @param sourceFieldName 源值字段名
     * @param targetFieldName 目标字段名
     * @param <T>             T
     * @return Annotation
     */
    public static <T extends Annotation> T copyAnnotationFieldValue(T annotation, String sourceFieldName, String targetFieldName) {
        if (ObjectUtil.isAllNotEmpty(annotation, sourceFieldName, targetFieldName)) {
            Map annotationFieldValueMap = (Map) ReflectUtil.getFieldValue(ReflectUtil.getFieldValue(annotation, "h"), "memberValues");
            annotationFieldValueMap.put(targetFieldName, annotationFieldValueMap.get(sourceFieldName));
        }
        return annotation;
    }

    /**
     * 如果目标字段值是空则拷贝源字段的属性值
     *
     * @param annotation      注解
     * @param sourceFieldName 源值字段名
     * @param targetFieldName 目标字段名
     * @param <T>             T
     * @return Annotation
     */
    public static <T extends Annotation> T emptyToCopyAnnotationFieldValue(T annotation, String sourceFieldName, String targetFieldName) {
        if (ObjectUtil.isAllNotEmpty(annotation, sourceFieldName, targetFieldName)) {
            if (ObjectUtil.isEmpty(getAnnotationFieldValue(annotation, targetFieldName))) {
                copyAnnotationFieldValue(annotation, sourceFieldName, targetFieldName);
            }
        }
        return annotation;
    }


    /**
     * 注解的值转成Map
     *
     * @param currentAnnotation 注解实例
     * @return Map
     */
    public static Map<String, Object> getAnnotationValueMap(Annotation currentAnnotation) {
        return Optional.ofNullable(currentAnnotation)
                .map(annotation -> {
                    Method[] objectMethods = ReflectUtil.getMethods(Object.class);
                    final List<Method> methods = ReflectUtil.getPublicMethods(annotation.getClass(), t -> {
                        if (ArrayUtil.isEmpty(t.getParameterTypes())) {
                            // 只读取无参方法
                            final String name = t.getName();
                            return (!"hashCode".equals(name))
                                    && (!"toString".equals(name))
                                    && (!"annotationType".equals(name))
                                    && (!ArrayUtil.contains(objectMethods, t));
                        }
                        return false;
                    });

                    final HashMap<String, Object> result = new HashMap<>(methods.size(), 1);
                    for (Method method : methods) {
                        result.put(method.getName(), ReflectUtil.invoke(annotation, method));
                    }
                    return result;
                }).orElse(CollectionUtils.newHashMap());
    }
}
