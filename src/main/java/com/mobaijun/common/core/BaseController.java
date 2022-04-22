package com.mobaijun.common.core;

import com.mobaijun.common.exception.CustomException;
import com.mobaijun.common.util.ObjectUtils;
import com.mobaijun.common.util.StringUtils;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: BaseController
 * 类描述： 通用数据处理
 *
 * @Author MoBaiJun 2022/4/22 16:54
 */
public class BaseController {

    /**
     * 参数是否为空的校验
     */
    public void assertNotNull(Object object, String message) {
        if (ObjectUtils.isEmpty(object)) {
            throw new CustomException(message);
        }
    }

    /**
     * 参数是否为空的校验
     */
    public void assertNotEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new CustomException(message);
        }
    }

    /**
     * 判断条件是否符合
     */
    public void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new CustomException(message);
        }
    }
}
