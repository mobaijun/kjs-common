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

import com.mobaijun.common.constant.StringConstant;
import com.mobaijun.common.util.ObjectUtil;
import com.mobaijun.common.util.StringUtil;
import com.mobaijun.common.util.reflect.ReflectUtil;

import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: EnhanceObjectUtils<br>
 * class description: 增强
 *
 * @author MoBaiJun 2022/11/23 21:23
 */
public class EnhanceObjectUtil extends ObjectUtil {

    /**
     * 获取层级value  【每个层级Key会下划线、驼峰都查】
     *
     * @param targetObj 目标元素  支持Bean以及Map
     * @param key       键值  通过分割符获取第几层的键值  使用英文句号进行分割
     * @return Object
     */
    public static Object getValue(Object targetObj, String key) {
        return getValue(targetObj, key, StringConstant.DOT);
    }

    /**
     * 获取层级value 【每个层级Key会下划线、驼峰都查】
     *
     * @param targetObj 目标元素支持 Bean 以及 Map
     * @param key       键值  通过分割符获取第几层的键值  分割 separator
     * @param separator 分割符 空则默认英文句号.
     * @return Object
     */
    @SuppressWarnings("all")
    public static Object getValue(Object targetObj, String key, String separator) {
        separator = StringUtil.blankToDefault(separator, StringConstant.DOT);
        Object result = null;
        if (isAllNotEmpty(targetObj, key)) {
            List<String> sonKeys = StringUtil.split(key, StringConstant.DOT);
            int index = 0;
            Object tempResult = targetObj;
            for (String sonKey : sonKeys) {
                if (tempResult == null) {
                    break;
                }
                Object columnValue1 = null;
                Object columnValue2 = null;
                if (tempResult instanceof Map) {
                    columnValue1 = ((Map) tempResult).get(sonKey);
                    columnValue2 = ((Map) tempResult).get(sonKey);
                } else {
                    columnValue1 = ReflectUtil.getFieldValue(tempResult, sonKey);
                    columnValue2 = ReflectUtil.getFieldValue(tempResult, sonKey);
                }
                tempResult = cn.hutool.core.util.ObjectUtil.defaultIfNull(columnValue1, columnValue2);
                index++;
            }
            // 层级字段获取到结果
            if (sonKeys.size() == index) {
                result = tempResult;
            }
        }
        return result;
    }
}
